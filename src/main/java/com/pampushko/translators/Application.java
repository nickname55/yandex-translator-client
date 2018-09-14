package com.pampushko.translators;

import com.pampushko.translators.models.TranslationResult;
import lombok.extern.slf4j.Slf4j;
import org.cfg4j.provider.ConfigurationProvider;

import static com.pampushko.translators.config.Config4j.configurationProvider;

@Slf4j
class Application
{
	public static ConfigurationProvider confProvider;
	
	static
	{
		confProvider = configurationProvider("application.yaml");
	}
	
	public static void main(String[] args)
	{
		String apiKey = confProvider.getProperty("app.apiKey", String.class);
		String apiKeyQueryParamName = confProvider.getProperty("app.apiKeyQueryParamName", String.class);
		String baseUrl = confProvider.getProperty("app.baseUrl", String.class);
		
		ApiClient apiClient = ApiClient.newBuilder()
				.apiKeyQueryParamName(apiKeyQueryParamName)
				.apiKey(apiKey)
				.baseUrl(baseUrl)
				.build();
		
		String translateDirection = "ru-en";
		String sourceText = "Том так и не смог сказать Мэри, что любит её."; //Tom was never able to tell Mary that he loved her.
		TranslationResult translationResult = apiClient.translateText(sourceText, translateDirection);
		
		System.out.println("Исходный текст");
		System.out.println("----------------------------------------------");
		System.out.println(sourceText);
		System.out.println();
		System.out.println("Переведённый текст:");
		System.out.println("----------------------------------------------");
		System.out.println(translationResult.getText().get(0));
	}
}
