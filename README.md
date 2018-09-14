## Project overview
Клиент для работы с Yandex Переводчиком  
## Motivation
Нужна библиотека для удобной работы с переводчиком небольших фрагментов текста  
## Code Example

```
package com.pampushko.translators.examples;

import com.pampushko.translators.ApiClient;
import com.pampushko.translators.models.TranslationResult;
import org.cfg4j.provider.ConfigurationProvider;

import static com.pampushko.translators.config.Config4j.configurationProvider;

class Application
{
	public static void main(String[] args)
	{
		ApiClient apiClient = buildApiClient();
		
		String translateDirection = "ru-en";
		String sourceText = "Том так и не смог сказать Мэри, что любит её.";
		
		TranslationResult translationResult = apiClient.translateText(sourceText, translateDirection);
		
		printResult(sourceText, translationResult);
	}
	
	public static ApiClient buildApiClient()
	{
		ConfigurationProvider confProvider = configurationProvider("application.yaml");
		
		String apiKey = confProvider.getProperty("app.apiKey", String.class);
		String apiKeyQueryParamName = confProvider.getProperty("app.apiKeyQueryParamName", String.class);
		String baseUrl = confProvider.getProperty("app.baseUrl", String.class);
		
		ApiClient apiClient = ApiClient.newBuilder()
				.apiKeyQueryParamName(apiKeyQueryParamName)
				.apiKey(apiKey)
				.baseUrl(baseUrl)
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

```
  
## Contributors
Alexander Pampushko
   
## License
  
Apache License 2.0
