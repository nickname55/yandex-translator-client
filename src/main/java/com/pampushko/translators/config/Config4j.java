package com.pampushko.translators.config;

import org.cfg4j.provider.ConfigurationProvider;
import org.cfg4j.provider.ConfigurationProviderBuilder;
import org.cfg4j.source.ConfigurationSource;
import org.cfg4j.source.classpath.ClasspathConfigurationSource;
import org.cfg4j.source.context.filesprovider.ConfigFilesProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.nio.file.Paths;
import java.util.Collections;

/**
 *
 */
public class Config4j
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public static ConfigurationProvider configurationProvider(String config)
	{
		// Specify which files to load. Configuration from both files will be merged.
		ConfigFilesProvider configFilesProvider = () -> Collections.singletonList(Paths.get(config));
		
		// Use classpath repository as configuration store
		ConfigurationSource source = new ClasspathConfigurationSource(configFilesProvider);
		
		// Create provider
		return new ConfigurationProviderBuilder()
				.withConfigurationSource(source)
				.build();
	}
}
