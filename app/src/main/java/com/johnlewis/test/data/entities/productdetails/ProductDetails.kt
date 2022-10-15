package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class ProductDetails(
    @SerializedName("detailsData") var detailsData: ArrayList<DetailsData> = arrayListOf()
)