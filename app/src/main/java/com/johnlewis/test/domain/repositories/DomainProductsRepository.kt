package com.johnlewis.test.domain.repositories

import com.johnlewis.test.domain.model.DomainProductDetails
import com.johnlewis.test.domain.model.DomainProductsModel
import com.johnlewis.test.domain.sealed.DomainSealedResponse

interface DomainProductsRepository {
    suspend fun getAllProducts(): DomainSealedResponse<List<DomainProductsModel>>
    suspend fun getProductDetails(productId: String) : DomainSealedResponse<DomainProductDetails?>
}