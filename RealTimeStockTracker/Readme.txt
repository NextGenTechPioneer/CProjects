# Real-Time Stock Tracker (ASP.NET Core MVC)

## Overview

This project is a simple Real-Time Stock Tracker web application built using ASP.NET Core MVC. It allows users to enter a stock ticker symbol and retrieve the latest stock price, change percentage, and last trading day information using the Alpha Vantage API.

## Features

- Responsive web interface to input stock ticker symbols.
- Real-time retrieval of stock data from Alpha Vantage API.
- Displays current price, change percentage, and last trading day.
- Handles errors gracefully if stock symbol is invalid or API call fails.
- Stores API key securely in `appsettings.json`.
- Uses dependency injection and HttpClient for efficient API calls.

## Prerequisites

- .NET 6.0 SDK or later installed.
- An Alpha Vantage API key (free signup at [https://www.alphavantage.co/](https://www.alphavantage.co/)).

## Getting Started

1. Clone this repository or download the source code.

2. Open the project in your preferred IDE (Visual Studio, VS Code).

3. Add your Alpha Vantage API key in `appsettings.json`:

   ```json
   {
     "AlphaVantage": {
       "ApiKey": "YOUR_API_KEY_HERE"
     }
   }

4. Restore dependencies and build the project:

bash
Copy
Edit
dotnet restore
dotnet build

5. Run app

dotnet run

---------------------------------------------------------------
Project Structure
Controllers/StockController.cs - Handles HTTP requests and communicates with the service.

Services/StockService.cs - Responsible for fetching stock data from Alpha Vantage API.

Views/Stock/Index.cshtml - User interface for input and display of stock information.

appsettings.json - Configuration file storing the API key.

Notes
This project is intended as a learning example for integrating external APIs in ASP.NET Core MVC.

The Alpha Vantage free API has request limits; be mindful of usage.

License
This project is provided as-is for educational purposes.

