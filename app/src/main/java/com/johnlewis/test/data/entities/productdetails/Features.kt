package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName
import com.johnlewis.test.data.entities.productdetails.Attributes


data class Features(

    @SerializedName("groupName") var groupName: String,
    @SerializedName("attributes") var attributes: ArrayList<Attributes> = arrayListOf()

)