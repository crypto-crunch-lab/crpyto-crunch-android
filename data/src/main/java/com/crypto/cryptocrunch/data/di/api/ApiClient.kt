package com.crypto.cryptocrunch.data.di.api

import com.crypto.cryptocrunch.di.api.CryptoService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var BASE_URL = "http://server.crypto-crunch-tech.com:8080"
    private var retrofit: Retrofit? = null

    fun provideCryptoService(): CryptoService = getRetrofit().create(CryptoService::class.java)

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