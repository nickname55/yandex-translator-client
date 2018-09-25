## Project overview
Клиент для работы с Yandex Переводчиком  
## Motivation
Нужна библиотека для удобной работы с переводчиком небольших фрагментов текста  
## Code Example

```
package com.pampushko.translators.examples;

import com.pampushko.translators.ApiClient;
import com.pampushko.translators.enums.DIRECTION_TR;
import org.cfg4j.provider.ConfigurationProvider;

import static com.pampushko.translators.config.Config4j.configurationProvider;
import static java.lang.System.out;

class ApplicationSingleText
{
	public static void main(String[] args)
	{
		//создаём клиент
		ApiClient apiClient = buildApiClient();
		//выбираем направление перевода (с русского на английский)
		DIRECTION_TR translateDirection = DIRECTION_TR.RU_EN;
		//исходный текст
		String sourceText = "Том так и не смог сказать Мэри, что любит её.";
		//выполняем перевод
		String translationResult = apiClient.translate(sourceText, translateDirection);
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
	
	public static void printResult(String sourceText, String translationResult)
	{
		out.println("Исходный текст");
		out.println("----------------------------------------------");
		out.println(sourceText);
		out.println();
		out.println("Переведённый текст:");
		out.println("----------------------------------------------");
		out.println(translationResult);
	}
}


```
  
## Contributors
Alexander Pampushko
   
## License
  
Apache License 2.0
