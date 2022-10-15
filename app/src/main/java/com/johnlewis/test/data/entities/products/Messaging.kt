package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName


data class Messaging (

  @SerializedName("title" ) var title : String? = null,
  @SerializedName("type"  ) var type  : String? = null

)