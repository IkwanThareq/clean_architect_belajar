package com.example.medium_clean_architecture.data.source.network

import android.net.sip.SipErrorCode.TIME_OUT
import okhttp3.logging.HttpLoggingInterceptor
import com.example.medium_clean_architecture.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkConfig {
    companion object {
        private const val BASE_URL = "https://newsapi.org/v2/"
        fun api(): ApiService {
            val logging = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG) {
                logging.level = HttpLoggingInterceptor.Level.BODY
            } else {
                logging.level = HttpLoggingInterceptor.Level.NONE
            }
            val client = OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .addInterceptor(logging)
                .connectTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .readTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(TIME_OUT.toLong(), TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiService::class.java)
        }
    }
}