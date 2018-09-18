package com.pampushko.translators.models;

import com.google.gson.annotations.SerializedName;
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
public class SupportedLanguagesResult extends BaseModel
{
	@SerializedName("dirs")
	Set<String> dirs;
	
	@SerializedName("langs")
	Map<String, String> languages;
}
