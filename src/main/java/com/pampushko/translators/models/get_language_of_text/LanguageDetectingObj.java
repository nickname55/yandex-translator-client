package com.pampushko.translators.models.get_language_of_text;

import com.google.gson.annotations.SerializedName;
import com.pampushko.translators.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 *
 */
@Setter
@Getter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class LanguageDetectingObj extends BaseModel
{
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("code")
	Integer code;
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("lang")
	String lang;
}
