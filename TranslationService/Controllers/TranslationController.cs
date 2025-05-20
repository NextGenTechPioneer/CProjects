using Microsoft.AspNetCore.Mvc;

[ApiController]
[Route("api/[controller]")]
public class TranslationController : ControllerBase
{
    private readonly ITranslationService _translationService;

    public TranslationController(ITranslationService translationService)
    {
        _translationService = translationService;
    }

    [HttpPost]
    public async Task<IActionResult> Translate([FromBody] TranslationRequest request)
    {
        if (request == null || string.IsNullOrWhiteSpace(request.Text))
            return BadRequest("Invalid request");

        var result = await _translationService.TranslateTextAsync(request.Text, request.ToLanguage);
        return Ok(new { TranslatedText = result });
    }
}