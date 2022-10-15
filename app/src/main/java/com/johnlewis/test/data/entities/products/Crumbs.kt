package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName


data class Crumbs (

  @SerializedName("displayName" ) var displayName : String? = null,
  @SerializedName("type"        ) var type        : String? = null,
  @SerializedName("clickable"   ) var clickable   : String? = null

)