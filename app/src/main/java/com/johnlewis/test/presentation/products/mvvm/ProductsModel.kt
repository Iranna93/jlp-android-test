package com.johnlewis.test.presentation.products.mvvm

import com.johnlewis.test.domain.model.DomainProductsModel
import com.johnlewis.test.domain.sealed.DomainSealedResponse
import com.johnlewis.test.domain.usecase.products.GetProductListUseCase
import javax.inject.Inject

class ProductsModel @Inject constructor(
    private val getProductListUseCase: GetProductListUseCase
) {
    suspend fun getProductsList(): DomainSealedResponse<List<DomainProductsModel>> {
        return getProductListUseCase.execute()
    }
}