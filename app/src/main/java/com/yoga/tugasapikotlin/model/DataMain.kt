package com.yoga.tugasapikotlin.model

import com.google.gson.annotations.SerializedName

data class DataMain (
    @field:SerializedName("data")
    val data:List<DataWisata>? = null
)