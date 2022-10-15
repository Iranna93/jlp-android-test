package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class DeliverySummary(

    @SerializedName("deliveryType") var deliveryType: String,
    @SerializedName("title") var title: String,
    @SerializedName("price") var price: String,
    @SerializedName("currency") var currency: String,
    @SerializedName("summary") var summary: String,
    @SerializedName("trialMessage") var trialMessage: String,
    @SerializedName("newTitle") var newTitle: String,
    @SerializedName("newSummary") var newSummary: String,
    @SerializedName("newPriority") var newPriority: Int,
    @SerializedName("newOptionId") var newOptionId: String

)