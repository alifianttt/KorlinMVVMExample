package com.yoga.tugasapikotlin.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tabel_wisata")
data class DataWisatadb (
    @PrimaryKey
    @ColumnInfo(name = "destination_id")
    val id:Int,
    @ColumnInfo(name = "destination_name")
    val dstName:String,
    @ColumnInfo(name = "destination_author")
    val dstAuthor:String,
    @ColumnInfo(name = "created_at")
    val createAt:String,
    @ColumnInfo(name = "updated_at")
    val updateAt:String,
    @ColumnInfo(name = "destination_category")
    val dstCategory:String,
    @ColumnInfo(name = "destination_lat")
    val dstLat:String,
    @ColumnInfo(name = "destination_long")
    val dstLong:String,
    @ColumnInfo(name = "destination_addres")
    val dstAddr:String,
    @ColumnInfo(name = "rata_rating")
    val dstRate:String,
    @ColumnInfo(name = "jumlah_response")
    val dstRespon:String
)