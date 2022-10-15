package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName

data class Price(
    @SerializedName("was") var was: String,
    @SerializedName("then1") var then1: String,
    @SerializedName("then2") var then2: String,
    @SerializedName("now") var now: String,
    @SerializedName("uom") var uom: String,
    @SerializedName("currency") var currency: String,
)