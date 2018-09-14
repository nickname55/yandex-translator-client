## Project overview
Клиент для работы с Yandex Переводчиком  
## Motivation
Нужна библиотека для удобной работы с переводчиком небольших фрагментов текста  
## Code Example

```
package com.pampushko.translators;

import com.pampushko.translators.models.get_translate_of_text.TranslateObj;
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
		
		ApiClient apiClient = ApiClient.newBuilder().apiKeyQueryParamName("key").apiKey(apiKey).baseUrl
				("https://translate.yandex.net/api/v1.5/tr.json/").build();
		
		String translateDirection = "ru-en";
		String sourceText = "Том так и не смог сказать Мэри, что любит её."; //Tom was never able to tell Mary that he loved her.
		TranslateObj translateObj = apiClient.getTranslateOfText(sourceText, translateDirection);
		
		System.out.println("Исходный текст");
		System.out.println("----------------------------------------------");
		System.out.println(sourceText);
		System.out.println();
		System.out.println("Переведённый текст:");
		System.out.println("----------------------------------------------");
		System.out.println(translateObj.getText().get(0));
	}
}
```
  
## Contributors
Alexander Pampushko
   
## License
  
Apache License 2.0
