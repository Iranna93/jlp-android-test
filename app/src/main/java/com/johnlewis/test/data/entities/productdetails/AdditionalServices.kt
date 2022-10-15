package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName

data class AdditionalServices(
    @SerializedName("includedServices") var includedServices: ArrayList<String> = arrayListOf(),
    @SerializedName("optionalServices") var optionalServices: ArrayList<OptionalServices> = arrayListOf()
)