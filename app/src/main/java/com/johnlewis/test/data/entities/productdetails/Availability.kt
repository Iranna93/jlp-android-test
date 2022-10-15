package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName

data class Availability(
    @SerializedName("stockLevel") var stockLevel: Int,
    @SerializedName("availabilityStatus") var availabilityStatus: String,
    @SerializedName("message") var message: String
)