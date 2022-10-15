package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName
import com.johnlewis.test.data.entities.productdetails.CustomProperties

data class OptionalServices(
    @SerializedName("id") var id: String,
    @SerializedName("associatedProductId") var associatedProductId: String,
    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String,
    @SerializedName("price") var price: String,
    @SerializedName("currency") var currency: String,
    @SerializedName("orderOnSite") var orderOnSite: Int,
    @SerializedName("type") var type: String,
    @SerializedName("url") var url: String,
    @SerializedName("customProperties") var customProperties: CustomProperties

)