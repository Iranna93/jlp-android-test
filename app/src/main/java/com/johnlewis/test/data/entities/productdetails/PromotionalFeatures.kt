package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class PromotionalFeatures(

    @SerializedName("title") var title: String,
    @SerializedName("iconUrl") var iconUrl: String,
    @SerializedName("linkUrl") var linkUrl: String,
    @SerializedName("description") var description: String,
    @SerializedName("longDescription") var longDescription: String

)