package com.johnlewis.test.data.boundary

import com.johnlewis.test.data.entities.productdetails.DetailsData
import com.johnlewis.test.data.entities.products.ProductsResponse
import com.johnlewis.test.domain.model.DomainProductDetails
import com.johnlewis.test.domain.model.DomainProductsModel
import javax.inject.Inject

class DomainMapper @Inject constructor() {
    fun mapDomainProduct(response: ProductsResponse): List<DomainProductsModel> {
        return response.products.map {
            DomainProductsModel(
                productId = it.productId,
                type = it.type,
                title = it.title,
                code = it.code,
                averageRating = it.averageRating,
                reviews = it.reviews,
                image = it.image,
                alternativeImageUrls = it.alternativeImageUrls,
                outOfStock = it.outOfStock,
                isAvailableToOrder = it.isAvailableToOrder,
                brand = it.brand,
                ageRestriction = it.ageRestriction,
                price = DomainProductsModel.Price(
                    was = it.price.was,
                    then1 = it.price.then1,
                    then2 = it.price.then2,
                    now = it.price.now,
                    uom = it.price.uom,
                    currency = it.price.currency
                )
            )
        }
    }

    fun mapDomainProductDetail(details: DetailsData): DomainProductDetails {

        var attributeList = emptyList<DomainProductDetails.Attributes>()
        for (feature in details.details.features) {
            attributeList = feature.attributes.map { attributes ->
                DomainProductDetails.Attributes(
                    value = attributes.value,
                    values = attributes.values,
                    multivalued = attributes.multivalued,
                    id = attributes.id,
                    name = attributes.name,
                    toolTip = attributes.toolTip,
                    uom = attributes.uom
                )
            }
        }

        return DomainProductDetails(
            productId = details.productId,
            title = details.title,
            productInformation = details.details.productInformation,
            price = DomainProductDetails.Price(
                was = details.price.was,
                then1 = details.price.then1,
                then2 = details.price.then2,
                now = details.price.now,
                uom = details.price.uom,
                currency = details.price.currency
            ),
            code = details.code,
            images = DomainProductDetails.Images(
                altText = details.media.images.altText,
                urls = details.media.images.urls
            ),
            additionalServices = DomainProductDetails.AdditionalServices(
                includedServices = details.additionalServices.includedServices,
                optionalServices = details.additionalServices.optionalServices
            ),
            attributes = attributeList as ArrayList<DomainProductDetails.Attributes>
        )
    }

}