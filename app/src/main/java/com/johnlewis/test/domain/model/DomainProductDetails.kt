package com.johnlewis.test.domain.model

import com.johnlewis.test.data.entities.productdetails.OptionalServices

data class DomainProductDetails(
    var productId: String,
    var title:String,
    var price: Price,
    var code: String,
    var images: Images,
    val productInformation:String,
    var additionalServices: AdditionalServices,
    var attributes: ArrayList<Attributes> = arrayListOf()
) {
    data class Images(
        var altText: String,
        var urls: ArrayList<String> = arrayListOf()
    )

    data class AdditionalServices(
        var includedServices: ArrayList<String> = arrayListOf(),
        var optionalServices: ArrayList<OptionalServices> = arrayListOf()
    )

    data class Attributes(
        var value: String,
        var values: ArrayList<String> = arrayListOf(),
        var multivalued: Boolean,
        var id: String,
        var name: String,
        var toolTip: String,
        var uom: String
    )
    data class Price(
        var was: String,
        var then1: String,
        var then2: String,
        var now: String,
        var uom: String,
        var currency: String,
    )
}