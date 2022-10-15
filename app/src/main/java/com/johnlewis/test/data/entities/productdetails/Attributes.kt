package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName

data class Attributes(
    @SerializedName("value") var value: String,
    @SerializedName("values") var values: ArrayList<String> = arrayListOf(),
    @SerializedName("multivalued") var multivalued: Boolean,
    @SerializedName("id") var id: String,
    @SerializedName("name") var name: String,
    @SerializedName("toolTip") var toolTip: String,
    @SerializedName("uom") var uom: String
)