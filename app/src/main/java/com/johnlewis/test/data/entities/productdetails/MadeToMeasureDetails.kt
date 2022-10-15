package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class MadeToMeasureDetails(

    @SerializedName("type") var type: String,
    @SerializedName("styles") var styles: String

)