package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class Images(
    @SerializedName("altText") var altText: String,
    @SerializedName("urls") var urls: ArrayList<String> = arrayListOf()
)