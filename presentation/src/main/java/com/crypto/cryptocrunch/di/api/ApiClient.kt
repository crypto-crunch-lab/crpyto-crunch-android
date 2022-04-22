package com.crypto.cryptocrunch.di.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    // Crypto BaseURL
    var BASE_URL = ""
    private var retrofit: Retrofit? = null

    fun provideCryptoApi(): CryptoApi = getRetrofit().create(CryptoApi::class.java)

    fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build()
        }
        return retrofit!!
    }
}

private fun createOkHttpClient(): OkHttpClient {
    val builder = OkHttpClient.Builder()
    val interceptor = HttpLoggingInterceptor()

    interceptor.level = HttpLoggingInterceptor.Level.BODY
    builder.addInterceptor(interceptor)

    return builder.build()
}