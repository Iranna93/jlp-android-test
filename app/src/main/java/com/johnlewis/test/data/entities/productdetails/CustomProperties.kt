package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName

data class CustomProperties(
    @SerializedName("warrantyCustomGeneric") var warrantyCustomGeneric: String,
    @SerializedName("warrantyCustomTooltip") var warrantyCustomTooltip: String,
    @SerializedName("warrantyCustomDescription") var warrantyCustomDescription: String,
    @SerializedName("warrantyCustomConfirm") var warrantyCustomConfirm: String

)