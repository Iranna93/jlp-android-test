package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName

data class Brand(
    @SerializedName("name") var name: String,
    @SerializedName("logo") var logo: String
)