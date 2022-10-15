package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class Media(
    @SerializedName("images") var images: Images,
    @SerializedName("360images") var fullImage: FullImage,
    @SerializedName("videos") var videos: Videos
)