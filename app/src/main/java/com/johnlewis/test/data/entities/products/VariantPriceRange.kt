package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName

data class VariantPriceRange(

    @SerializedName("display") var display: Display? = Display(),
    @SerializedName("for") var fo: String? = null,
    @SerializedName("reductionHistory") var reductionHistory: ArrayList<String> = arrayListOf(),
    @SerializedName("value") var value: Value? = Value()

)