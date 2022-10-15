package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class Skus(

    @SerializedName("id") var id: String,
    @SerializedName("skuTitle") var skuTitle: String,
    @SerializedName("shortSkuTitle") var shortSkuTitle: String,
    @SerializedName("color") var color: String,
    @SerializedName("size") var size: String,
    @SerializedName("sizeHeadline") var sizeHeadline: String,
    @SerializedName("swatchUrl") var swatchUrl: String,
    @SerializedName("availability") var availability: Availability,
    @SerializedName("price") var price: Price,
    @SerializedName("code") var code: String,
    @SerializedName("leadTime") var leadTime: String,
    @SerializedName("d2cDeliveryLeadTime") var d2cDeliveryLeadTime: String,
    @SerializedName("media") var media: Media,
    @SerializedName("brandName") var brandName: String,
    @SerializedName("priceBand") var priceBand: String,
    @SerializedName("dynamicAttributes") var dynamicAttributes: DynamicAttributes,
    @SerializedName("ticketType") var ticketType: String,
    @SerializedName("mainframeProductId") var mainframeProductId: String
)