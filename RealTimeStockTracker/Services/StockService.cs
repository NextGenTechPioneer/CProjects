using System;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;
using Microsoft.Extensions.Configuration;
using RealTimeStockTracker.Models;

namespace RealTimeStockTracker.Services
{
    public class StockService
    {
        private readonly HttpClient _httpClient;
        private readonly IConfiguration _configuration;

        public StockService(HttpClient httpClient, IConfiguration configuration)
        {
            _httpClient = httpClient;
            _configuration = configuration;
        }

        public async Task<StockQuote> GetStockQuoteAsync(string symbol)
        {
            var apiKey = _configuration["AlphaVantage:ApiKey"];
            var url = $"https://www.alphavantage.co/query?function=GLOBAL_QUOTE&symbol={symbol}&apikey={apiKey}";
            var response = await _httpClient.GetStringAsync(url);

            using JsonDocument doc = JsonDocument.Parse(response);
            var root = doc.RootElement.GetProperty("Global Quote");

            return new StockQuote
            {
                Symbol = symbol,
                CurrentPrice = decimal.Parse(root.GetProperty("05. price").GetString()),
                LastUpdated = DateTime.Now
            };
        }
    }
}