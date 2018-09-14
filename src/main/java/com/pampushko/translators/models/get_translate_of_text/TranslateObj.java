package com.pampushko.translators.models.get_translate_of_text;

import com.google.gson.annotations.SerializedName;
import com.pampushko.translators.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class TranslateObj extends BaseModel
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
	
	/**
	 * Пример:
	 * <br>
	 */
	@SerializedName("text")
	List<String> text;
}
