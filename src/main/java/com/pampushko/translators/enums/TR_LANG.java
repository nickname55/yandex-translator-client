package com.pampushko.translators.enums;

/**
 *
 */
public enum TR_LANG
{
	AFRIKAANS("af"),
	AMHARIC("am"),
	ARABIC("ar"),
	AZERBAIJANI("az"),
	BASHKIR("ba"),
	BELARUSIAN("be"),
	BULGARIAN("bg"),
	BENGALI("bn"),
	BOSNIAN("bs"),
	CATALAN("ca"),
	CEBUANO("ceb"),
	CZECH("cs"),
	WELSH("cy"),
	DANISH("da"),
	GERMAN("de"),
	GREEK("el"),
	ENGLISH("en"),
	ESPERANTO("eo"),
	SPANISH("es"),
	ESTONIAN("et"),
	BASQUE("eu"),
	PERSIAN("fa"),
	FINNISH("fi"),
	FRENCH("fr"),
	IRISH("ga"),
	SCOTTISH_GAELIC("gd"),
	GALICIAN("gl"),
	GUJARATI("gu"),
	HEBREW("he"),
	HINDI("hi"),
	CROATIAN("hr"),
	HAITIAN("ht"),
	HUNGARIAN("hu"),
	ARMENIAN("hy"),
	INDONESIAN("id"),
	ICELANDIC("is"),
	ITALIAN("it"),
	JAPANESE("ja"),
	JAVANESE("jv"),
	GEORGIAN("ka"),
	KAZAKH("kk"),
	KHMER("km"),
	KANNADA("kn"),
	KOREAN("ko"),
	KYRGYZ("ky"),
	LATIN("la"),
	LUXEMBOURGISH("lb"),
	LAO("lo"),
	LITHUANIAN("lt"),
	LATVIAN("lv"),
	MALAGASY("mg"),
	MARI("mhr"),
	MAORI("mi"),
	MACEDONIAN("mk"),
	MALAYALAM("ml"),
	MONGOLIAN("mn"),
	MARATHI("mr"),
	HILL_MARI("mrj"),
	MALAY("ms"),
	MALTESE("mt"),
	BURMESE("my"),
	NEPALI("ne"),
	DUTCH("nl"),
	NORWEGIAN("no"),
	PUNJABI("pa"),
	PAPIAMENTO("pap"),
	POLISH("pl"),
	PORTUGUESE("pt"),
	ROMANIAN("ro"),
	RUSSIAN("ru"),
	SINHALESE("si"),
	SLOVAK("sk"),
	SLOVENIAN("sl"),
	ALBANIAN("sq"),
	SERBIAN("sr"),
	SUNDANESE("su"),
	SWEDISH("sv"),
	SWAHILI("sw"),
	TAMIL("ta"),
	TELUGU("te"),
	TAJIK("tg"),
	THAI("th"),
	TAGALOG("tl"),
	TURKISH("tr"),
	TATAR("tt"),
	UDMURT("udm"),
	UKRAINIAN("uk"),
	URDU("ur"),
	UZBEK("uz"),
	VIETNAMESE("vi"),
	XHOSA("xh"),
	YIDDISH("yi"),
	CHINESE("zh");
	
	String language;
	
	TR_LANG(String language)
	{
		this.language = language;
	}
	
	/**
	 *
	 */
	public String getLanguage()
	{
		return this.language;
	}
	
	/**
	 * Parse string input to enum.
	 * Case insensitive.
	 *
	 * @param input
	 * 		String to parse
	 *
	 * @return The parsed, or null on failure.
	 */
	public static TR_LANG parse(String input)
	{
		if (null == input)
		{
			return null;
		}
		input = input.trim().replaceAll(" ", "_");
		for (TR_LANG state : values())
		{
			if (state.language.equalsIgnoreCase(input))
			{
				return state;
			}
		}
		return null;
	}
	
	@Override
	public String toString()
	{
		return language;
	}
}
