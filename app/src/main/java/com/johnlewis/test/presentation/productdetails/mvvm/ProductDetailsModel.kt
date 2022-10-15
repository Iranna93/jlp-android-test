package com.johnlewis.test.presentation.productdetails.mvvm

import com.johnlewis.test.domain.model.DomainProductDetails
import com.johnlewis.test.domain.sealed.DomainSealedResponse
import com.johnlewis.test.domain.usecase.products.GetProductDetailsUseCase
import javax.inject.Inject

class ProductDetailsModel @Inject constructor(
    private val getProductDetailsUseCase: GetProductDetailsUseCase
) {
    suspend fun getProductDetails(productId: String): DomainSealedResponse<DomainProductDetails?> {
        return getProductDetailsUseCase.execute(productId = productId)
    }
}