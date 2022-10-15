package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class FullImage(
    @SerializedName("swfUrl") var swfUrl: String,
    @SerializedName("urls") var urls: ArrayList<String> = arrayListOf()
)