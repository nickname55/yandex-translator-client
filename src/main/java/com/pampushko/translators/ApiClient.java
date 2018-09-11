package com.pampushko.translators;

import lombok.extern.slf4j.Slf4j;
import retrofit2.Retrofit;

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
	//реализация методов клиента ...
}
