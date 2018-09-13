package com.pampushko.translators.models.get_supported_langs;

import com.google.gson.annotations.SerializedName;
import com.pampushko.translators.models.BaseModel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Set;

/**
 *
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@Slf4j
public class SupportedLanguages extends BaseModel
{
	@SerializedName("dirs")
	Set<String> dirs;
	
	//@JsonAdapter(value = LanguageSubObjDeserializer.class)
	@SerializedName("langs")
	Map<String, String> languages;
}
