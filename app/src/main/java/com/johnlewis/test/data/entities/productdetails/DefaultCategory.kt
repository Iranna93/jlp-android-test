package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class DefaultCategory (

  @SerializedName("id"   ) var id   : String,
  @SerializedName("name" ) var name : String

)