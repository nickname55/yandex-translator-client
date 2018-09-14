package com.pampushko.translators;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Base64;

/**
 *
 */
@Slf4j
class RetrofitManager
{
	/**
	 * Создаем Retrofit экземпляр клиента
	 * <br />
	 *
	 * @param apiClient
	 * 		клиент (из клиента берем credetials, baseUrl)
	 *
	 * @return экземпляр Retrofit
	 */
	Retrofit getRetrofit(ApiClient apiClient)
	{
		final String login = apiClient.login;
		final String password = apiClient.password;
		final String apiKey = apiClient.apiKey;
		final String apiKeyQueryParamName = apiClient.apiKeyQueryParamName;
		
		//HTTP Basic authentication
		final String credentials = login + ":" + password;
		//base64.
		final String encodedCredentials = "Basic " + Base64.getEncoder().encodeToString(credentials.getBytes());
		
		//создаем gson-билдер
		Gson gson = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
				.disableHtmlEscaping()
				.create();
		
		//создаем интерсептор для логирования
		HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
		httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
		
		Interceptor customHeadersInterceptor = new Interceptor()
		{
			@Override
			public Response intercept(Chain chain) throws IOException
			{
				Request originalRequest = chain.request();
				
				HttpUrl originalRequestUrl = originalRequest.url();
				HttpUrl url = originalRequestUrl.newBuilder().addQueryParameter(apiKeyQueryParamName, apiKey).build();
				
				Request request = originalRequest.newBuilder()
						
						.url(url)
						
						.addHeader("Authorization", "Basic dGVzdHJvb3Q6NzEyNTU0")
						.addHeader("User-Agent", "curl/7.47.0")
						.addHeader("X-Atlassian-Token", "nocheck")
						.addHeader("Content-Type", "application/json")
						.addHeader("Accept", "application/json")
						.build();
				
				return chain.proceed(request);
			}
		};
		
		//создаем http-клиент OkHttp и добавляем в него интерсепторы
		OkHttpClient httpClient = new OkHttpClient.Builder()
				.addInterceptor(customHeadersInterceptor)
				.addInterceptor(httpLoggingInterceptor)
				.build();
		
		//создаем экземпляр Ретрофита и добавляем к нему HTTP-клиент
		Retrofit retrofit = new Retrofit.Builder()
				.baseUrl(apiClient.baseUrl)
				.addConverterFactory(GsonConverterFactory.create(gson))
				.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
				.client(httpClient)
				.build();
		
		return retrofit;
	}
}
