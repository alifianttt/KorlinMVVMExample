package com.yoga.tugasapikotlin.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

class RestApi {


    fun getNetwork():Retrofit{
        return Retrofit.Builder().baseUrl("https://gumilombok.id/api/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun api():ApiService{
        return getNetwork().create(ApiService::class.java)
    }
}