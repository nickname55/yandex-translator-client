package com.pampushko.translators.examples;

import com.pampushko.translators.ApiClient;
import com.pampushko.translators.enums.DIRECTION_TR;
import org.cfg4j.provider.ConfigurationProvider;

import java.util.ArrayList;
import java.util.List;

import static com.pampushko.translators.config.Config4j.configurationProvider;
import static java.lang.System.out;

class ApplicationTextList
{
	public static void main(String[] args)
	{
		//создаём клиент
		ApiClient apiClient = buildApiClient();
		//выбираем направление перевода (с русского на английский)
		DIRECTION_TR translateDirection = DIRECTION_TR.RU_EN;
		//исходные тексты
		List<String> sourceTexts = new ArrayList<String>()
		{{
			add("Том так и не смог сказать Мэри, что любит её.");
			add("Том любит яблоки");
			add("Мэри любит Сережу");
		}};
		//выполняем перевод
		List<String> translationResult = apiClient.translate(sourceTexts, translateDirection);
		//печатаем исходный текст и результат перевода
		printResult(sourceTexts, translationResult);
	}
	
	public static ApiClient buildApiClient()
	{
		ConfigurationProvider confProvider = configurationProvider("application.yaml");
		
		String apiKey = confProvider.getProperty("app.apiKey", String.class);
		String baseUrl = confProvider.getProperty("app.baseUrl", String.class);
		ApiClient apiClient = ApiClient.newBuilder().baseUrl(baseUrl).apiKey(apiKey).build();
		return apiClient;
	}
	
	public static void printResult(List<String> sourceTexts, List<String> translationResults)
	{
		for (int i = 0; i < sourceTexts.size(); i++)
		{
			out.println("Исходный текст " + (i + 1));
			out.println("----------------------------------------------");
			out.println(sourceTexts.get(i));
			out.println();
			out.println("Переведённый текст:");
			out.println("----------------------------------------------");
			out.println(translationResults.get(i));
			out.println("==============================================");
			out.println();
		}
	}
}
