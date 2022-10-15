package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName


data class Services(

    @SerializedName("__typename") var _typename: String? = null,
    @SerializedName("title") var title: String? = null,
    @SerializedName("automaticallyIncluded") var automaticallyIncluded: Boolean? = null

)