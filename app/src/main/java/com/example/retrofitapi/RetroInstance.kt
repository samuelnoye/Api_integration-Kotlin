package com.example.retrofitapi

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.GsonConverterFactory

import retrofit2.Retrofit


class RetroInstance {
    companion object {

        val baseUrl = "https://gorest.co.in/public-api/"
        fun getInstance(): Retrofit {

            val logging = HttpLoggingInterceptor()
            logging.level = (HttpLoggingInterceptor.Level.BODY)
            val client = OkHttpClient.Builder()
            client.addInterceptor(logging)
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}