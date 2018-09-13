import com.pampushko.translators.ApiClient;
import org.cfg4j.provider.ConfigurationProvider;
import org.junit.jupiter.api.BeforeAll;

import static com.pampushko.translators.config.Config4j.configurationProvider;

/**
 *
 */
public class BaseTest
{
	public static ConfigurationProvider confProvider;
	
	static
	{
		confProvider = configurationProvider("application.yaml");
		//appProperties = confProvider.bind("app", AppProperties.class);
	}
	
	public static ApiClient apiClient;
	
	@BeforeAll
	public static void setUpOnce()
	{
		String apiKey = confProvider.getProperty("app.apiKey", String.class);
		apiClient = ApiClient.newBuilder().apiKeyQueryParamName("key").apiKey(apiKey).baseUrl
				("https://translate.yandex" +
						".net/api/v1.5/tr.json/").build();
		
	}
}
