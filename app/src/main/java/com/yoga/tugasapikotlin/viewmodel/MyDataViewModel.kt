package com.yoga.tugasapikotlin.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yoga.tugasapikotlin.db.WisataDb
import com.yoga.tugasapikotlin.db.WisataRepo
import com.yoga.tugasapikotlin.model.ListWisatadb
import kotlinx.coroutines.launch

class MyDataViewModel(appilcation : Application):ViewModel() {
    private val repo:WisataRepo
    val allDdata : LiveData<ListWisatadb>

    init {
        val dataDao = WisataDb.getInstance(appilcation, viewModelScope).wisatadao()
        repo = WisataRepo(dataDao)
        allDdata = repo.alldata
    }

    fun Insert(dataWisatadb: ListWisatadb)=viewModelScope.launch {
        repo.insert(dataWisatadb)
    }

}