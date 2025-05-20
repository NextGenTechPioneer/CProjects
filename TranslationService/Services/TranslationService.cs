public interface ITranslationService
{
    Task<string> TranslateTextAsync(string text, string toLanguage);
}

public class TranslationService : ITranslationService
{
    private readonly IConfiguration _configuration;
    private readonly HttpClient _httpClient;

    public TranslationService(IConfiguration configuration)
    {
        _configuration = configuration;
        _httpClient = new HttpClient();
    }

    public async Task<string> TranslateTextAsync(string text, string toLanguage)
    {
        var subscriptionKey = _configuration["AzureTranslator:Key"];
        var endpoint = _configuration["AzureTranslator:Endpoint"];
        var location = _configuration["AzureTranslator:Region"];

        var route = $"/translate?api-version=3.0&to={toLanguage}";
        var body = new[] { new { Text = text } };

        var request = new HttpRequestMessage
        {
            Method = HttpMethod.Post,
            RequestUri = new Uri(endpoint + route),
            Content = new StringContent(System.Text.Json.JsonSerializer.Serialize(body), Encoding.UTF8, "application/json")
        };
        request.Headers.Add("Ocp-Apim-Subscription-Key", subscriptionKey);
        request.Headers.Add("Ocp-Apim-Subscription-Region", location);

        var response = await _httpClient.SendAsync(request);
        var jsonResponse = await response.Content.ReadAsStringAsync();
        var json = System.Text.Json.JsonDocument.Parse(jsonResponse);
        return json.RootElement[0].GetProperty("translations")[0].GetProperty("text").GetString();
    }
}