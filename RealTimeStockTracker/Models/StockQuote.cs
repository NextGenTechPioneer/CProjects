using System;

namespace RealTimeStockTracker.Models
{
    public class StockQuote
    {
        public string Symbol { get; set; }
        public decimal CurrentPrice { get; set; }
        public DateTime LastUpdated { get; set; }
    }
}