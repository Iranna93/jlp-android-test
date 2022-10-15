package com.johnlewis.test.domain.usecase.products

import com.johnlewis.test.domain.model.DomainProductDetails
import com.johnlewis.test.domain.model.DomainProductsModel
import com.johnlewis.test.domain.repositories.DomainProductsRepository
import com.johnlewis.test.domain.sealed.DomainSealedResponse
import com.johnlewis.test.domain.usecase.BaseParameterisedUseCase
import com.johnlewis.test.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetProductDetailsUseCase @Inject constructor(
    private val domainProductsRepository: DomainProductsRepository
) : BaseParameterisedUseCase<String, DomainSealedResponse<DomainProductDetails?>>() {
    override suspend fun execute(productId: String): DomainSealedResponse<DomainProductDetails?> {
        return domainProductsRepository.getProductDetails(productId = productId)
    }
}