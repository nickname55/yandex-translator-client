package com.pampushko.translators;

import com.pampushko.translators.models.get_supported_langs.SupportedLanguages;
import retrofit2.Call;
import retrofit2.http.*;

/**
 *
 */
public interface Api
{
	/**
	 * Получение списка поддерживаемых языков
	 * Get the list of supported languages
	 * <br />
	 *
	 * @param ui
	 * 		язык на котором приводить названия доступных языков
	 */
	@GET("getLangs")
	Call<SupportedLanguages> getListSupportedLanguages(@Query("ui") String ui); //ui example: "en"
	
	/**
	 * Определение языка, на котором написан заданный текст.
	 * Detect the language
	 * <br />
	 * @param hint Список наиболее вероятных языков (им будет отдаваться предпочтение при определении языка текста). Разделитель списка — запятая.
	 * @param text UrlEncoded образец текста, который мы передаём для определения языка
	 */
	@FormUrlEncoded
	@POST("detect")
	Call<LanguageDetectingObj> getLanguageOfText(@Field("text") String text,
	                                             @Query("hint") String hint); //hint example: "en,ru"
	
	/**
	 * Перевод текста с указанным направлением перевода
	 * Translates text to the specified language.
	 * <br />
	 */
	@POST("translate")
	Call<Object> getTranslateOfText(@Query("lang") String langPair); //langPair example: "en-ru"
}
