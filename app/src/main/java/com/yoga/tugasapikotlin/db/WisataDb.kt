package com.yoga.tugasapikotlin.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.yoga.tugasapikotlin.dao.DataDao
import com.yoga.tugasapikotlin.model.DataWisatadb
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = arrayOf(DataWisatadb::class), version = 1)
abstract class WisataDb : RoomDatabase() {
    abstract fun wisatadao():DataDao

    companion object{
        private var INSTANCE:WisataDb? = null
        fun getInstance(context: Context , scope:CoroutineScope):WisataDb{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WisataDb::class.java, "wisatadb"
                ).addCallback(DatabaseCallback(scope))
                    .build()
                INSTANCE = instance

                instance
            }
        }

        private class DatabaseCallback(private val scope: CoroutineScope):RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO){
                        populateData(database.wisatadao())
                    }
                }
            }
        }

        suspend fun populateData(wisata:DataDao){

        }

    }
}