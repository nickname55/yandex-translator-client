package com.pampushko.translators.config;

/**
 *
 */
public interface AppProperties
{
	String apikey();
	
	ProxySettings proxySettings();
	
	interface ProxySettings
	{
		Http http();
		
		Https https();
		
	}
	
	interface Http
	{
		String proxyHost();
		
		String proxyPort();
		
		String proxyLogin();
		
		String proxyPassword();
	}
	
	interface Https
	{
		String proxyHost();
		
		String proxyPort();
		
		String proxyLogin();
		
		String proxyPassword();
	}
}
