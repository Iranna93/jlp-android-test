package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName


data class DefaultParentCategory (

  @SerializedName("id"   ) var id   : String? = null,
  @SerializedName("name" ) var name : String? = null

)