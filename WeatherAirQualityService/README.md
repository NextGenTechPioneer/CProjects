# Unified Weather & Air Quality API

## Description
This API provides real-time weather and air quality data for a given city using OpenWeatherMap and AirVisual APIs. It uses Redis for caching and FastAPI for serving.

## Requirements
- Python 3.7+
- Redis running locally or remotely
- API keys for:
  - [OpenWeatherMap](https://openweathermap.org/api)
  - [AirVisual](https://www.iqair.com/world-air-quality)

## Setup

### 1. Clone the repository and set up the environment
```
python -m venv venv
source venv/bin/activate   # on Windows use venv\Scripts\activate
pip install -r requirements.txt
```

### 2. Set up `.env`
Create a `.env` file and add your API keys:
```
WEATHER_API_KEY=your_openweathermap_api_key
AIR_QUALITY_API_KEY=your_airvisual_api_key
```

### 3. Start Redis
Ensure Redis is running locally on port 6379.

### 4. Run the app
```
uvicorn app.main:app --reload
```

### 5. Access Swagger UI
Go to [http://localhost:8000/docs](http://localhost:8000/docs)

## Endpoints

- `/weather_air_quality/{city}`: Get weather and air quality data for a given city.
