package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class Options(

    @SerializedName("id") var id: String,
    @SerializedName("price") var price: String,
    @SerializedName("currency") var currency: String,
    @SerializedName("shortDescription") var shortDescription: String,
    @SerializedName("standardDescription") var standardDescription: String,
    @SerializedName("date") var date: String,
    @SerializedName("dateMessage") var dateMessage: String,
    @SerializedName("trialMessage") var trialMessage: String,
    @SerializedName("isApprovedSupplier") var isApprovedSupplier: Boolean,
    @SerializedName("leadTime") var leadTime: Int,
    @SerializedName("cutOffTime") var cutOffTime: Int,
    @SerializedName("newShortDescription") var newShortDescription: String,
    @SerializedName("newStandardDescription") var newStandardDescription: String,
    @SerializedName("newPriority") var newPriority: Int

)