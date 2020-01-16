package com.yoga.tugasapikotlin.db

import androidx.lifecycle.LiveData
import com.yoga.tugasapikotlin.dao.DataDao
import com.yoga.tugasapikotlin.model.ListWisatadb

class WisataRepo(private val wisatadao:DataDao) {
    val alldata:LiveData<ListWisatadb> = wisatadao.getAllData()

    suspend fun insert(data: ListWisatadb){
        wisatadao.insertAll(data)
    }
}