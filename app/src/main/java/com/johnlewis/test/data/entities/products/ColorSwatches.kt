package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName

data class ColorSwatches(
    @SerializedName("color") var color: String? = null,
    @SerializedName("basicColor") var basicColor: String? = null,
    @SerializedName("colorSwatchUrl") var colorSwatchUrl: String? = null,
    @SerializedName("imageUrl") var imageUrl: String? = null,
    @SerializedName("isAvailable") var isAvailable: Boolean? = null,
    @SerializedName("skuId") var skuId: String? = null,
    @SerializedName("id") var id: String? = null,
    @SerializedName("isColorOfDefaultVariant") var isColorOfDefaultVariant: Boolean? = null
)