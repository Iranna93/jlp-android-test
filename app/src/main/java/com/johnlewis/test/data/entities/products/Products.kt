package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName

data class Products(
    @SerializedName("productId") var productId: String,
    @SerializedName("type") var type: String,
    @SerializedName("title") var title: String,
    @SerializedName("code") var code: String,
    @SerializedName("averageRating") var averageRating: Double = 0.0,
    @SerializedName("reviews") var reviews: Int = 0,
    @SerializedName("image") var image: String,
    @SerializedName("alternativeImageUrls") var alternativeImageUrls: ArrayList<String> = arrayListOf(),
    @SerializedName("displaySpecialOffer") var displaySpecialOffer: String? = null,
    @SerializedName("nonPromoMessage") var nonPromoMessage: String? = null,
    @SerializedName("defaultSkuId") var defaultSkuId: String? = null,
    @SerializedName("defaultVariantId") var defaultVariantId: String? = null,
    @SerializedName("colorSwatches") var colorSwatches: ArrayList<ColorSwatches> = arrayListOf(),
    @SerializedName("outOfStock") var outOfStock: Boolean,
    @SerializedName("isAvailableToOrder") var isAvailableToOrder: Boolean,
    @SerializedName("emailMeWhenAvailable") var emailMeWhenAvailable: Boolean? = null,
    @SerializedName("compare") var compare: Boolean? = null,
    @SerializedName("fabric") var fabric: String? = null,
    @SerializedName("swatchAvailable") var swatchAvailable: Boolean? = null,
    @SerializedName("brand") var brand: String,
    @SerializedName("ageRestriction") var ageRestriction: Int,
    @SerializedName("isInStoreOnly") var isInStoreOnly: Boolean? = null,
    @SerializedName("isMadeToMeasure") var isMadeToMeasure: Boolean? = null,
    @SerializedName("isBundle") var isBundle: Boolean? = null,
    @SerializedName("isProductSet") var isProductSet: Boolean? = null,
    @SerializedName("dynamicAttributes") var dynamicAttributes: DynamicAttributes? = DynamicAttributes(),
    @SerializedName("futureRelease") var futureRelease: Boolean? = null,
    @SerializedName("multiSku") var multiSku: Boolean? = null,
    @SerializedName("fabricByLength") var fabricByLength: Boolean? = null,
    @SerializedName("messaging") var messaging: ArrayList<Messaging> = arrayListOf(),
    @SerializedName("variantPriceRange") var variantPriceRange: VariantPriceRange? = VariantPriceRange(),
    @SerializedName("services") var services: ArrayList<Services> = arrayListOf(),
    @SerializedName("attributes") var attributes: ArrayList<Attributes> = arrayListOf(),
    @SerializedName("hiddenAttributes") var hiddenAttributes: ArrayList<HiddenAttributes> = arrayListOf(),
    @SerializedName("permanentOos") var permanentOos: Boolean? = null,
    @SerializedName("defaultParentCategory") var defaultParentCategory: DefaultParentCategory? = DefaultParentCategory(),
    @SerializedName("price") var price: Price
)