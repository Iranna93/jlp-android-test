package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName


data class Display(
    @SerializedName("max") var max: String? = null,
    @SerializedName("min") var min: String? = null
)