package com.pampushko.translators.examples;

import com.pampushko.translators.ApiClient;
import com.pampushko.translators.models.TranslationResult;
import lombok.extern.slf4j.Slf4j;
import org.cfg4j.provider.ConfigurationProvider;

import static com.pampushko.translators.config.Config4j.configurationProvider;

@Slf4j
class Application
{
	public static void main(String[] args)
	{
		ApiClient apiClient = buildApiClient();
		
		String translateDirection = "ru-en";
		String sourceText = "Том так и не смог сказать Мэри, что любит её.";
		//Tom was never able to tell Mary that he loved her.
		
		TranslationResult translationResult = apiClient.translateText(sourceText, translateDirection);
		
		printResult(sourceText, translationResult);
	}
	
	public static ApiClient buildApiClient()
	{
		ConfigurationProvider confProvider = configurationProvider("application.yaml");
		String apiKey = confProvider.getProperty("app.apiKey", String.class);
		
		ApiClient apiClient = ApiClient.newBuilder()
				.apiKeyQueryParamName("key")
				.apiKey(apiKey)
				.baseUrl("https://translate.yandex.net/api/v1.5/tr.json/")
				.build();
		return apiClient;
	}
	
	public static void printResult(String sourceText, TranslationResult translationResult)
	{
		System.out.println("Исходный текст");
		System.out.println("----------------------------------------------");
		System.out.println(sourceText);
		System.out.println();
		System.out.println("Переведённый текст:");
		System.out.println("----------------------------------------------");
		System.out.println(translationResult.getText().get(0));
	}
}
