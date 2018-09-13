package com.pampushko.translators;

import com.pampushko.translators.config.AppProperties;
import lombok.extern.slf4j.Slf4j;
import org.cfg4j.provider.ConfigurationProvider;

import static com.pampushko.translators.config.Config4j.configurationProvider;

/**
 * <br />
 */
@Slf4j
public class Application
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
		
		String hint = "en,ru,de,tr"; //Список наиболее вероятных языков (им будет отдаваться предпочтение при определении языка текста). Разделитель списка — запятая.
		String text = "1978 yılında ekonomik reformların uygulanmasından beri Çin ekonomisi, Dünya'nın en hızlı " +
				"büyüyen ekonomilerinden biri olmuştur."; //турецкий язык
		LanguageDetectingObj language = apiClient.getLanguageOfText(text, hint);
		
		System.out.println();
		System.out.println();
		System.out.println("получили код языка из переданного образца текста (tr-турецкий)");
		System.out.println("----------------------------------------------");
		System.out.println(language.getLang());
		System.out.println();
		System.out.println();
		System.out.println("----------------------------------------------");
		System.out.println("Исходный текст:");
		System.out.println(text);
	}
}
