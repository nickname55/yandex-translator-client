package com.pampushko.translators;

import com.pampushko.translators.models.LanguageDetectingResult;
import com.pampushko.translators.models.SupportedLanguagesResult;
import com.pampushko.translators.models.TranslationResult;
import lombok.extern.slf4j.Slf4j;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;

/**
 *
 */
@Slf4j
public class ApiClient
{
	/**
	 * Логин
	 * <br />
	 */
	String login;
	
	/**
	 * Пароль
	 * <br />
	 */
	String password;
	
	/**
	 * Ключ API
	 * <br />
	 */
	String apiKey;
	
	/**
	 * Название параметра запроса,
	 * Этот параметр запроса, мы будем затем добавлять ко всем отправляемым запросам
	 * Значением этого параметра будет Api-ключ
	 * (Имя параметра может быть, "key" или "apiKey" в зависимости от того как это реализовано в API)
	 * <br />
	 */
	String apiKeyQueryParamName;
	
	/**
	 * базовый URL
	 * <br />
	 */
	String baseUrl;
	
	/**
	 * Ссылка на экземпляр интерфейса UpmApi
	 * <br />
	 */
	private Api api;
	
	/**
	 * Приватный конструктор,
	 * <br />
	 * т.к. мы будем создавать экземпляр клиента через Builder
	 * <br />
	 */
	private ApiClient()
	{
	
	}
	
	//========================================================================
	public class Builder
	{
		private Builder()
		{
		
		}
		
		public Builder login(String login)
		{
			ApiClient.this.login = login;
			return this;
		}
		
		public Builder password(String password)
		{
			ApiClient.this.password = password;
			return this;
		}
		
		public Builder apiKey(String apiKey)
		{
			ApiClient.this.apiKey = apiKey;
			return this;
		}
		
		public Builder apiKeyQueryParamName(String apiKeyQueryParamName)
		{
			ApiClient.this.apiKeyQueryParamName = apiKeyQueryParamName;
			return this;
		}
		
		public Builder baseUrl(String baseUrl)
		{
			ApiClient.this.baseUrl = baseUrl;
			return this;
		}
		
		/**
		 * настраиваем REST-адаптер, который будет использоваться для работы с API
		 * <br />
		 * И создаем Retrofit-клиент, согласно описанию API в интерфейсе {@link Api}
		 * <br />
		 *
		 * @return
		 */
		public ApiClient build()
		{
			Retrofit retrofit = new RetrofitManager().getRetrofit(ApiClient.this);
			ApiClient.this.api = retrofit.create(Api.class);
			return ApiClient.this;
		}
	}
	//========================================================================
	
	/**
	 * создаём новый builder для создания ApiClient -та*
	 *
	 * @return экземпляр Builder-ра
	 */
	public static Builder newBuilder()
	{
		return new ApiClient().new Builder();
	}
	//========================================================================
	
	//реализация методов клиента
	
	/**
	 * Получение списка поддерживаемых языков
	 * Get the list of supported languages
	 *
	 * @param ui
	 * 		язык на котором приводить названия доступных языков
	 * 		<br />
	 */
	public SupportedLanguagesResult getListSupportedLanguages(String ui) //ui example: "en"
	{
		SupportedLanguagesResult resultObj = null;
		try
		{
			Call<SupportedLanguagesResult> call = api.getListSupportedLanguages(ui);
			Response<SupportedLanguagesResult> response = call.execute();
			SupportedLanguagesResult body = response.body();
			resultObj = body;
		}
		catch (IOException ex)
		{
			log.error("error", ex);
		}
		return resultObj;
	}
	
	/**
	 * Определение языка, на котором написан заданный текст.
	 * Detect the language
	 * <br />
	 *
	 * @param hint
	 * 		Список наиболее вероятных языков (им будет отдаваться предпочтение при определении языка текста). Разделитель списка — запятая.
	 * @param text
	 * 		UrlEncoded образец текста, который мы передаём для определения языка
	 */
	public LanguageDetectingResult detectTextLanguage(String text, String hint) //hint example: "en,ru,de"
	{
		LanguageDetectingResult resultObj = null;
		try
		{
			Call<LanguageDetectingResult> call = api.detectTextLanguage(text, hint);
			Response<LanguageDetectingResult> response = call.execute();
			LanguageDetectingResult body = response.body();
			resultObj = body;
		}
		catch (IOException ex)
		{
			log.error("error", ex);
		}
		return resultObj;
	}
	
	/**
	 * Перевод текста с указанным направлением перевода
	 * Translates text to the specified language.
	 * <br />
	 */
	public TranslationResult translateText(String text, String translateDirection) //langPair example: "en-ru"
	{
		TranslationResult resultObj = null;
		
		try
		{
			Call<TranslationResult> call = api.translateText(text, translateDirection);
			Response<TranslationResult> response = call.execute();
			TranslationResult body = response.body();
			resultObj = body;
		}
		catch (IOException ex)
		{
			log.error("error", ex);
		}
		
		return resultObj;
	}
}
