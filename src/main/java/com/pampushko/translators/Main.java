package com.pampushko.translators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

/**
 *
 */
public class Main
{
	private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
	
	public static void main(String[] args)
	{
		test();
	}
	
	private static void test()
	{
		System.out.println("Hello world");
	}
}
