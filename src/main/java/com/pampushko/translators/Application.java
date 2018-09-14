package com.pampushko.translators;

import com.pampushko.translators.config.AppProperties;
import com.pampushko.translators.models.get_translate_of_text.TranslateObj;
import lombok.extern.slf4j.Slf4j;
import org.cfg4j.provider.ConfigurationProvider;

import static com.pampushko.translators.config.Config4j.configurationProvider;

/**
 * <br />
 */
@Slf4j
class Application
{
	public static AppProperties appProperties;
	public static ConfigurationProvider confProvider;
	
	static
	{
		confProvider = configurationProvider("application.yaml");
		//appProperties = confProvider.bind("app", AppProperties.class);
	}
	
	public static void main(String[] args)
	{
		String proxyHost = confProvider.getProperty("app.proxySettings.http.proxyHost", String.class);
		String proxyPort = confProvider.getProperty("app.proxySettings.http.proxyPort", String.class);
		String proxyLogin = confProvider.getProperty("app.proxySettings.http.proxyLogin", String.class);
		String proxyPassword = confProvider.getProperty("app.proxySettings.http.proxyPassword", String.class);
		String apiKey = confProvider.getProperty("app.apiKey", String.class);
		
		System.out.println(proxyHost);
		System.out.println(proxyPort);
		System.out.println(proxyLogin);
		System.out.println(proxyPassword);
		System.out.println(apiKey);
		
		ApiClient apiClient = ApiClient.newBuilder().apiKeyQueryParamName("key").apiKey(apiKey).baseUrl
				("https://translate.yandex" +
						".net/api/v1.5/tr.json/").build();
		
		String translateDirection = "ru-en";
		String sourceText = "Том так и не смог сказать Мэри, что любит её."; //Tom was never able to tell Mary that he loved her.
		TranslateObj translateObj = apiClient.getTranslateOfText(sourceText, translateDirection);
		
		System.out.println();
		System.out.println();
		System.out.println("Исходный текст");
		System.out.println("----------------------------------------------");
		System.out.println(sourceText);
		System.out.println();
		System.out.println();
		System.out.println("Переведённый текст:");
		System.out.println("----------------------------------------------");
		System.out.println(translateObj.getText().get(0));
	}
}
