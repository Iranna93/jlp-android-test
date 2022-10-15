package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName

data class VideosList(

    @SerializedName("videoType") var videoType: String,
    @SerializedName("type") var type: String,
    @SerializedName("name") var name: String,
    @SerializedName("videoImageURL") var videoImageURL: String,
    @SerializedName("url") var url: String

)