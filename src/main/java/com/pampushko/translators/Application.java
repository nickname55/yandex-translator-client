package com.pampushko.translators;

import com.pampushko.translators.enums.TR_DIRECTION;
import com.pampushko.translators.models.TranslationResult;
import lombok.extern.slf4j.Slf4j;
import org.cfg4j.provider.ConfigurationProvider;

import static java.lang.System.out;
import static com.pampushko.translators.config.Config4j.configurationProvider;

@Slf4j
class Application
{
	public static void main(String[] args)
	{
		//создаём клиент
		ApiClient apiClient = buildApiClient();
		//выбираем направление перевода (с русского на английский)
		TR_DIRECTION translateDirection = TR_DIRECTION.RU_EN;
		//исходный текст
		String sourceText = "Том так и не смог сказать Мэри, что любит её.";
		//выполняем перевод
		TranslationResult translationResult = apiClient.translate(sourceText, translateDirection);
		//печатаем исходный текст и результат перевода
		printResult(sourceText, translationResult);
	}
	
	public static ApiClient buildApiClient()
	{
		ConfigurationProvider confProvider = configurationProvider("application.yaml");
		
		String apiKey = confProvider.getProperty("app.apiKey", String.class);
		String baseUrl = confProvider.getProperty("app.baseUrl", String.class);
		ApiClient apiClient = ApiClient.newBuilder().baseUrl(baseUrl).apiKey(apiKey).build();
		return apiClient;
	}
	
	public static void printResult(String sourceText, TranslationResult translationResult)
	{
		out.println("Исходный текст");
		out.println("----------------------------------------------");
		out.println(sourceText);
		out.println();
		out.println("Переведённый текст:");
		out.println("----------------------------------------------");
		out.println(translationResult.getText().get(0));
	}
}
