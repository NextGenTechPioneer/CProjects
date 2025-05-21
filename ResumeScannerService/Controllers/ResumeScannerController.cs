using Microsoft.AspNetCore.Mvc;

[ApiController]
[Route("api/[controller]")]
public class ResumeScannerController : ControllerBase
{
    private readonly IResumeScannerService _scannerService;
    private readonly ILogger<ResumeScannerController> _logger;

    public ResumeScannerController(IResumeScannerService scannerService, ILogger<ResumeScannerController> logger)
    {
        _scannerService = scannerService;
        _logger = logger;
    }

    [HttpPost]
    public async Task<IActionResult> ScanResume([FromBody] ResumeRequest request)
    {
        if (string.IsNullOrWhiteSpace(request.ResumeText))
        {
            _logger.LogWarning("Received empty resume text.");
            return BadRequest("Resume text cannot be empty.");
        }

        var result = await _scannerService.AnalyzeResumeAsync(request.ResumeText);
        return Ok(result);
    }

[HttpPost("upload")]
        public async Task<IActionResult> UploadResume(IFormFile resumeFile)
        {
            if (resumeFile == null || resumeFile.Length == 0)
                return BadRequest("File is empty");

            using var reader = new StreamReader(resumeFile.OpenReadStream());
            var resumeText = await reader.ReadToEndAsync();

            _logger.LogInformation("Analyzing uploaded resume file");
            var result = await _scannerService.AnalyzeResumeAsync(resumeText);
            return Ok(result);
        }
    }
}