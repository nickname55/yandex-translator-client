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
		
		System.out.println(proxyHost);
		System.out.println(proxyPort);
		System.out.println(proxyLogin);
		System.out.println(proxyPassword);
	}
}
