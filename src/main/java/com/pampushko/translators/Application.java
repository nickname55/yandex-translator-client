package com.pampushko.translators;

import com.pampushko.translators.config.AppProperties;
import com.pampushko.translators.models.get_supported_langs.SupportedLanguages;
import lombok.extern.slf4j.Slf4j;
import org.cfg4j.provider.ConfigurationProvider;

import java.util.Map;

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
		
		//String hint = "en,ru";
		String ui = "ru"; //язык на котором приводить названия доступных языков
		SupportedLanguages listSupportedLanguages = apiClient.getListSupportedLanguages(ui);
		
		System.out.println();
		System.out.println();
		System.out.println("получили полное наименование языка с кодом mi");
		System.out.println("----------------------------------------------");
		System.out.println(listSupportedLanguages.getLanguages().get("mi"));
		
		System.out.println();
		System.out.println();
		System.out.println("распечатали все доступные направления перевода");
		System.out.println("----------------------------------------------");
		for (String dir : listSupportedLanguages.getDirs())
		{
			System.out.println(dir);
		}
		
		System.out.println();
		System.out.println();
		System.out.println("проверили наличие определённого перевода \"uk-en\"");
		System.out.println("----------------------------------------------");
		System.out.println(listSupportedLanguages.getDirs().contains("uk-en"));
		
		System.out.println();
		System.out.println();
		System.out.println("выведем список поддерживаемых языков");
		System.out.println("----------------------------------------------");
		for (Map.Entry<String, String> entry : listSupportedLanguages.getLanguages().entrySet())
		{
			System.out.println(entry.getKey() + " (полное название " + entry.getValue() + ")");
		}
		System.out.println();
	}
}
