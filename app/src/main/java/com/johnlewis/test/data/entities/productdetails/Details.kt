package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class Details(
    @SerializedName("returns") var returns: String,
    @SerializedName("returnsHeadline") var returnsHeadline: String,
    @SerializedName("termsAndConditions") var termsAndConditions: String,
    @SerializedName("productInformation") var productInformation: String,
    @SerializedName("features") var features: ArrayList<Features> = arrayListOf(),
    @SerializedName("careGuide") var careGuide: ArrayList<String> = arrayListOf(),
//    @SerializedName("featuredArticles") var featuredArticles: ArrayList<String>? = arrayListOf(),
    @SerializedName("editorsNotes") var editorsNotes: String,
    @SerializedName("buyingGuides") var buyingGuides: ArrayList<BuyingGuides> = arrayListOf(),
    @SerializedName("sizeGuides") var sizeGuides: ArrayList<String> = arrayListOf(),
    @SerializedName("weLikeItBecause") var weLikeItBecause: String
)