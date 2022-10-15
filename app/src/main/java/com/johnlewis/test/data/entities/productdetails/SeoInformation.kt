package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class SeoInformation(

    @SerializedName("title") var title: String,
    @SerializedName("description") var description: String

)