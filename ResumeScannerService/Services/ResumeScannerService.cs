public interface IResumeScannerService
{
    Task<ResumeScanResult> AnalyzeResumeAsync(string resumeText);
}

public class ResumeScannerService : IResumeScannerService
{
    private readonly IConfiguration _configuration;
    private readonly HttpClient _httpClient;
    private readonly ILogger<ResumeScannerService> _logger;

    public ResumeScannerService(IConfiguration configuration, ILogger<ResumeScannerService> logger)
    {
        _configuration = configuration;
        _httpClient = new HttpClient();
        _logger = logger;
    }

    public async Task<ResumeScanResult> AnalyzeResumeAsync(string resumeText)
    {
        var endpoint = _configuration["AzureAI:Endpoint"];
        var key = _configuration["AzureAI:Key"];
        var deploymentName = _configuration["AzureAI:DeploymentName"];

        var url = $"{endpoint}/openai/deployments/{deploymentName}/chat/completions?api-version=2024-02-15-preview";

        var requestBody = new
        {
            messages = new[] {
                new { role = "system", content = "You are a professional resume reviewer." },
                new { role = "user", content = $"Analyze this resume and provide strengths, weaknesses, and potential job fit:\n\n{resumeText}" }
            },
            temperature = 0.2,
            max_tokens = 500
        };

        var request = new HttpRequestMessage(HttpMethod.Post, url);
        request.Headers.Add("api-key", key);
        request.Content = new StringContent(System.Text.Json.JsonSerializer.Serialize(requestBody), Encoding.UTF8, "application/json");

        _logger.LogInformation("Sending resume to Azure AI for analysis.");

        var response = await _httpClient.SendAsync(request);
        response.EnsureSuccessStatusCode();

        var jsonResponse = await response.Content.ReadAsStringAsync();
        var json = System.Text.Json.JsonDocument.Parse(jsonResponse);

        var analysis = json.RootElement
            .GetProperty("choices")[0]
            .GetProperty("message")
            .GetProperty("content")
            .GetString();

        return new ResumeScanResult { Analysis = analysis };
    }
}