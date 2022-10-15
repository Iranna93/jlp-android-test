package com.johnlewis.test.domain.model

data class DomainProductsModel(
    var productId: String,
    var type: String,
    var title: String,
    var code: String? = null,
    var averageRating: Double,
    var reviews: Int,
    var image: String,
    var alternativeImageUrls: ArrayList<String>,
    var outOfStock: Boolean,
    var isAvailableToOrder: Boolean,
    var brand: String,
    var ageRestriction: Int,
    var price: Price
) {
    data class Price(
        var was: String,
        var then1: String,
        var then2: String,
        var now: String,
        var uom: String,
        var currency: String,
    )
}