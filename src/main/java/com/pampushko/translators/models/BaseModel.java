package com.pampushko.translators.models;

import com.google.gson.GsonBuilder;

/**
 *
 */
public class BaseModel
{
	@Override
	public String toString()
	{
		return new GsonBuilder().disableHtmlEscaping().create().toJson(this);
	}
}
