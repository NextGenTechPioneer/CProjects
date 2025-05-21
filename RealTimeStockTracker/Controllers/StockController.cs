using Microsoft.AspNetCore.Mvc;
using RealTimeStockTracker.Services;
using System.Threading.Tasks;

namespace RealTimeStockTracker.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class StockController : ControllerBase
    {
        private readonly StockService _stockService;

        public StockController(StockService stockService)
        {
            _stockService = stockService;
        }

        [HttpGet("{symbol}")]
        public async Task<IActionResult> GetQuote(string symbol)
        {
            var quote = await _stockService.GetStockQuoteAsync(symbol);
            return Ok(quote);
        }
    }
}