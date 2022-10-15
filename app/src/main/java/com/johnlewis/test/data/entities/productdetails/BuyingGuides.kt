package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName

data class BuyingGuides(
    @SerializedName("title") var title: String,
    @SerializedName("image") var image: String,
    @SerializedName("linkUrl") var linkUrl: String,
    @SerializedName("linkText") var linkText: String,
    @SerializedName("longDescription") var longDescription: String
)