package com.pampushko.translators.enums;

/**
 *
 */
public enum TR_DIRECTION
{
	AZ_RU("az-ru"),
	BE_BG("be-bg"),
	BE_CS("be-cs"),
	BE_DE("be-de"),
	BE_EN("be-en"),
	BE_ES("be-es"),
	BE_FR("be-fr"),
	BE_IT("be-it"),
	BE_PL("be-pl"),
	BE_RO("be-ro"),
	BE_RU("be-ru"),
	BE_SR("be-sr"),
	BE_TR("be-tr"),
	BG_BE("bg-be"),
	BG_RU("bg-ru"),
	BG_UK("bg-uk"),
	CA_EN("ca-en"),
	CA_RU("ca-ru"),
	CS_BE("cs-be"),
	CS_EN("cs-en"),
	CS_RU("cs-ru"),
	CS_UK("cs-uk"),
	DA_EN("da-en"),
	DA_RU("da-ru"),
	DE_BE("de-be"),
	DE_EN("de-en"),
	DE_ES("de-es"),
	DE_FR("de-fr"),
	DE_IT("de-it"),
	DE_RU("de-ru"),
	DE_TR("de-tr"),
	DE_UK("de-uk"),
	EL_EN("el-en"),
	EL_RU("el-ru"),
	EN_BE("en-be"),
	EN_CA("en-ca"),
	EN_CS("en-cs"),
	EN_DA("en-da"),
	EN_DE("en-de"),
	EN_EL("en-el"),
	EN_ES("en-es"),
	EN_ET("en-et"),
	EN_FI("en-fi"),
	EN_FR("en-fr"),
	EN_HU("en-hu"),
	EN_IT("en-it"),
	EN_LT("en-lt"),
	EN_LV("en-lv"),
	EN_MK("en-mk"),
	EN_NL("en-nl"),
	EN_NO("en-no"),
	EN_PT("en-pt"),
	EN_RU("en-ru"),
	EN_SK("en-sk"),
	EN_SL("en-sl"),
	EN_SQ("en-sq"),
	EN_SV("en-sv"),
	EN_TR("en-tr"),
	EN_UK("en-uk"),
	ES_BE("es-be"),
	ES_DE("es-de"),
	ES_EN("es-en"),
	ES_RU("es-ru"),
	ES_UK("es-uk"),
	ET_EN("et-en"),
	ET_RU("et-ru"),
	FI_EN("fi-en"),
	FI_RU("fi-ru"),
	FR_BE("fr-be"),
	FR_DE("fr-de"),
	FR_EN("fr-en"),
	FR_RU("fr-ru"),
	FR_UK("fr-uk"),
	HR_RU("hr-ru"),
	HU_EN("hu-en"),
	HU_RU("hu-ru"),
	HY_RU("hy-ru"),
	IT_BE("it-be"),
	IT_DE("it-de"),
	IT_EN("it-en"),
	IT_RU("it-ru"),
	IT_UK("it-uk"),
	LT_EN("lt-en"),
	LT_RU("lt-ru"),
	LV_EN("lv-en"),
	LV_RU("lv-ru"),
	MK_EN("mk-en"),
	MK_RU("mk-ru"),
	NL_EN("nl-en"),
	NL_RU("nl-ru"),
	NO_EN("no-en"),
	NO_RU("no-ru"),
	PL_BE("pl-be"),
	PL_RU("pl-ru"),
	PL_UK("pl-uk"),
	PT_EN("pt-en"),
	PT_RU("pt-ru"),
	RO_BE("ro-be"),
	RO_RU("ro-ru"),
	RO_UK("ro-uk"),
	RU_AZ("ru-az"),
	RU_BE("ru-be"),
	RU_BG("ru-bg"),
	RU_CA("ru-ca"),
	RU_CS("ru-cs"),
	RU_DA("ru-da"),
	RU_DE("ru-de"),
	RU_EL("ru-el"),
	RU_EN("ru-en"),
	RU_ES("ru-es"),
	RU_ET("ru-et"),
	RU_FI("ru-fi"),
	RU_FR("ru-fr"),
	RU_HR("ru-hr"),
	RU_HU("ru-hu"),
	RU_HY("ru-hy"),
	RU_IT("ru-it"),
	RU_LT("ru-lt"),
	RU_LV("ru-lv"),
	RU_MK("ru-mk"),
	RU_NL("ru-nl"),
	RU_NO("ru-no"),
	RU_PL("ru-pl"),
	RU_PT("ru-pt"),
	RU_RO("ru-ro"),
	RU_SK("ru-sk"),
	RU_SL("ru-sl"),
	RU_SQ("ru-sq"),
	RU_SR("ru-sr"),
	RU_SV("ru-sv"),
	RU_TR("ru-tr"),
	RU_UK("ru-uk"),
	SK_EN("sk-en"),
	SK_RU("sk-ru"),
	SL_EN("sl-en"),
	SL_RU("sl-ru"),
	SQ_EN("sq-en"),
	SQ_RU("sq-ru"),
	SR_BE("sr-be"),
	SR_RU("sr-ru"),
	SR_UK("sr-uk"),
	SV_EN("sv-en"),
	SV_RU("sv-ru"),
	TR_BE("tr-be"),
	TR_DE("tr-de"),
	TR_EN("tr-en"),
	TR_RU("tr-ru"),
	TR_UK("tr-uk"),
	UK_BG("uk-bg"),
	UK_CS("uk-cs"),
	UK_DE("uk-de"),
	UK_EN("uk-en"),
	UK_ES("uk-es"),
	UK_FR("uk-fr"),
	UK_IT("uk-it"),
	UK_PL("uk-pl"),
	UK_RO("uk-ro"),
	UK_RU("uk-ru"),
	UK_SR("uk-sr"),
	UK_TR("uk-tr");
	
	String translateDirection;
	
	TR_DIRECTION(String translateDirection)
	{
		this.translateDirection = translateDirection;
	}
	
	/**
	 *
	 */
	public String getTranslateDirection()
	{
		return this.translateDirection;
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
	public static TR_DIRECTION parse(String input)
	{
		if (null == input)
		{
			return null;
		}
		input = input.trim().replaceAll("_", "-");
		for (TR_DIRECTION state : values())
		{
			if (state.translateDirection.equalsIgnoreCase(input))
			{
				return state;
			}
		}
		return null;
	}
	
	@Override
	public String toString()
	{
		return translateDirection;
	}
}
