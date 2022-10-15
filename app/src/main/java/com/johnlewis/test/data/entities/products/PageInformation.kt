package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName


data class PageInformation(
    @SerializedName("title") var title: String? = null,
    @SerializedName("heading") var heading: String? = null,
    @SerializedName("description") var description: String? = null,
    @SerializedName("noIndex") var noIndex: Boolean? = null,
    @SerializedName("noFollow") var noFollow: Boolean? = null
)