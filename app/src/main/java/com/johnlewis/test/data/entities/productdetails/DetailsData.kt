package com.johnlewis.test.data.entities.productdetails

import com.google.gson.annotations.SerializedName


data class DetailsData(
    @SerializedName("productId") var productId: String,
    @SerializedName("bundleProducts") var bundleProducts: ArrayList<String> = arrayListOf(),
    @SerializedName("details") var details: Details,
    @SerializedName("deliveries") var deliveries: ArrayList<Deliveries> = arrayListOf(),
    @SerializedName("deliverySummary") var deliverySummary: ArrayList<DeliverySummary> = arrayListOf(),
    @SerializedName("emailMeWhenAvailable") var emailMeWhenAvailable: Boolean,
    @SerializedName("skus") var skus: ArrayList<Skus> = arrayListOf(),
    @SerializedName("title") var title: String,
    @SerializedName("defaultSku") var defaultSku: String,
    @SerializedName("storeOnly") var storeOnly: Boolean,
    @SerializedName("type") var type: String,
    @SerializedName("ageRestriction") var ageRestriction: Int,
    @SerializedName("seoURL") var seoURL: String,
    @SerializedName("isFBL") var isFBL: Boolean,
    @SerializedName("averageRating") var averageRating: Double,
    @SerializedName("numberOfReviews") var numberOfReviews: Int,
    @SerializedName("price") var price: Price,
    @SerializedName("code") var code: String,
    @SerializedName("specialOffers") var specialOffers: SpecialOffers,
    @SerializedName("displaySpecialOffer") var displaySpecialOffer: String,
    @SerializedName("templateType") var templateType: String,
    @SerializedName("priceBands") var priceBands: ArrayList<String> = arrayListOf(),
    @SerializedName("legs") var legs: ArrayList<String> = arrayListOf(),
    @SerializedName("swatchCategoryType") var swatchCategoryType: String,
    @SerializedName("deliveryFulfilledBy") var deliveryFulfilledBy: String,
    @SerializedName("additionalServices") var additionalServices: AdditionalServices = AdditionalServices(),
    @SerializedName("media") var media: Media,
    @SerializedName("setElements") var setElements: ArrayList<String> = arrayListOf(),
    @SerializedName("headingTypes") var headingTypes: ArrayList<String> = arrayListOf(),
    @SerializedName("moreFromRange") var moreFromRange: ArrayList<String> = arrayListOf(),
    @SerializedName("promotionalFeatures") var promotionalFeatures: ArrayList<PromotionalFeatures> = arrayListOf(),
    @SerializedName("setInformation") var setInformation: String,
    @SerializedName("specialOfferBundles") var specialOfferBundles: ArrayList<String> = arrayListOf(),
    @SerializedName("fixedRelatedProducts") var fixedRelatedProducts: ArrayList<String> = arrayListOf(),
    @SerializedName("siblingSets") var siblingSets: ArrayList<String> = arrayListOf(),
    @SerializedName("defaultCategory") var defaultCategory: DefaultCategory,
    @SerializedName("parentCategories") var parentCategories: ArrayList<ParentCategories> = arrayListOf(),
    @SerializedName("releaseDateTimestamp") var releaseDateTimestamp: Int,
    @SerializedName("crumbs") var crumbs: ArrayList<Crumbs> = arrayListOf(),
    @SerializedName("seoInformation") var seoInformation: SeoInformation,
    @SerializedName("isInTopNkuCategory") var isInTopNkuCategory: Boolean,
    @SerializedName("brand") var brand: Brand,
    @SerializedName("swatchAvailable") var swatchAvailable: String,
    @SerializedName("madeToMeasureDetails") var madeToMeasureDetails: MadeToMeasureDetails,
    @SerializedName("isAsafShape") var isAsafShape: Boolean,
    @SerializedName("dynamicAttributes") var dynamicAttributes: DynamicAttributes,
    @SerializedName("excludeFromLiveChat") var excludeFromLiveChat: Boolean,
    @SerializedName("webPimProductType") var webPimProductType: String,
    @SerializedName("nonPromoMessage") var nonPromoMessage: String,
    @SerializedName("preorderable") var preorderable: Boolean
)