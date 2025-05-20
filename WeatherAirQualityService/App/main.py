from fastapi import FastAPI, HTTPException
import requests
import redis
from dotenv import load_dotenv
import os

load_dotenv()

app = FastAPI(
    title="Unified Weather & Air Quality API",
    description="Provides current weather and air quality data for a given city.",
    version="1.0.0"
)

redis_client = redis.Redis(host="localhost", port=6379, db=0)

WEATHER_API_KEY = os.getenv("WEATHER_API_KEY")
AIR_QUALITY_API_KEY = os.getenv("AIR_QUALITY_API_KEY")

@app.get("/weather_air_quality/{city}")
def get_weather_and_air_quality(city: str):
    cache_key = f"data:{city.lower()}"
    cached_data = redis_client.get(cache_key)
    if cached_data:
        return eval(cached_data)

    try:
        weather_response = requests.get(
            f"http://api.openweathermap.org/data/2.5/weather?q={city}&appid={WEATHER_API_KEY}&units=metric")
        weather_data = weather_response.json()

        air_quality_response = requests.get(
            f"http://api.airvisual.com/v2/city?city={city}&key={AIR_QUALITY_API_KEY}")
        air_quality_data = air_quality_response.json()

        result = {
            "weather": {
                "description": weather_data["weather"][0]["description"],
                "temperature": weather_data["main"]["temp"],
                "humidity": weather_data["main"]["humidity"]
            },
            "air_quality": {
                "aqi": air_quality_data["data"]["current"]["pollution"]["aqius"]
            }
        }

        redis_client.setex(cache_key, 3600, str(result))  # Cache for 1 hour
        return result

    except Exception as e:
        raise HTTPException(status_code=500, detail=str(e))
