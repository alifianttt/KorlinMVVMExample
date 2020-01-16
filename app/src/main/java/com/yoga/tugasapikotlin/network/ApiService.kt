package com.yoga.tugasapikotlin.network

import retrofit2.Call
import com.yoga.tugasapikotlin.model.DataMain
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {

    @POST("destination")
    @FormUrlEncoded
    fun wisata(@Field("offset") ofset:Int, @Field("limit") limit:Int):Call<DataMain>
}