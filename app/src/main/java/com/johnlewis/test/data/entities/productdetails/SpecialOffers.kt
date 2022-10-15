package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName

data class SpecialOffers(

    @SerializedName("priceMatched") var priceMatched: String,
    @SerializedName("offer") var offer: String,
    @SerializedName("customPromotionalMessage") var customPromotionalMessage: String,
    @SerializedName("bundleHeadline") var bundleHeadline: String,

    )