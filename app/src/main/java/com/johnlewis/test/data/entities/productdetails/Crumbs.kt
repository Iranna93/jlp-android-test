package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class Crumbs(

    @SerializedName("type") var type: String,
    @SerializedName("displayName") var displayName: String,
    @SerializedName("item") var item: String,
    @SerializedName("clickable") var clickable: String

)