package com.yoga.tugasapikotlin.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.yoga.tugasapikotlin.model.DataWisatadb
import com.yoga.tugasapikotlin.model.ListWisatadb

@Dao
interface DataDao {
    @Query("Select * From tabel_wisata")
    fun getAllData():LiveData<ListWisatadb>

    @Insert(onConflict = REPLACE)
    fun insertAll(wisatadb: ListWisatadb)

}