package com.yoga.tugasapikotlin.model

import com.google.gson.annotations.SerializedName

data class DataWisata (
    @field:SerializedName("destination_id")
    val id:Int,
    @field:SerializedName("destination_name")
    val dstName:String,
    @field:SerializedName("destination_author")
    val dstAuthor:String,
    @field:SerializedName("created_at")
    val createAt:String,
    @field:SerializedName("updated_at")
    val updateAt:String,
    @field:SerializedName("destination_category")
    val dstCategory:String,
    @field:SerializedName("destination_lat")
    val dstLat:String,
    @field:SerializedName("destination_long")
    val dstLong:String,
    @field:SerializedName("destination_addres")
    val dstAddr:String,
    @field:SerializedName("rata_rating")
    val dstRating:String,
    @field:SerializedName("jumlah_response")
    val dstRespon:String
)