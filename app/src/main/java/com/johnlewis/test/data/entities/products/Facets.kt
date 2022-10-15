package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName


data class Facets(

    @SerializedName("dimensionName") var dimensionName: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("type") var type: String? = null,
    @SerializedName("tooltip") var tooltip: String? = null,
    @SerializedName("filterTypes") var filterTypes: ArrayList<String> = arrayListOf(),
    @SerializedName("details") var details: ArrayList<Details> = arrayListOf()

)