package com.yoga.tugasapikotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yoga.tugasapikotlin.model.DataMain
import com.yoga.tugasapikotlin.network.RestApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MyViewModel : ViewModel(){
    private var data = MutableLiveData<DataMain>()
    private var status = MutableLiveData<Boolean>()


    fun getData(offset:Int, limit:Int){
        status.value = true

        RestApi().api().wisata(offset, limit).enqueue(object : Callback<DataMain>{
            override fun onFailure(call: Call<DataMain>, t: Throwable) {
                status.value = true
                data.value = null
            }

            override fun onResponse(call: Call<DataMain>, response: Response<DataMain>) {
                status.value = false

                if (response.isSuccessful){
                    data.value = response.body()
                } else {
                    status.value = true
                }
            }
        })
    }
    fun setData() : MutableLiveData<DataMain>{
        return data
    }

    fun getStatus():MutableLiveData<Boolean>{
        status.value = true
        return status
    }
}