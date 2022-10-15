package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class Deliveries(

    @SerializedName("deliveryType") var deliveryType: String,
    @SerializedName("options") var options: ArrayList<Options> = arrayListOf()

)