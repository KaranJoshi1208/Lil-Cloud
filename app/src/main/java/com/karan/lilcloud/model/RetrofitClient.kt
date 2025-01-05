package com.karan.lilcloud.model

import android.content.Context
import com.android.volley.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitClient {

//    val cacheSize = 10*1024*1024
//    val cache = Cache(Context.)



    private val client = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .build()

    val retrofit_ACCU : Retrofit = Retrofit.Builder()
        .baseUrl("https://dataservice.accuweather.com")
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}