package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("key") var key: String? = null,
    @SerializedName("values") var values: ArrayList<String> = arrayListOf(),
    @SerializedName("displayName") var displayName: String? = null
)