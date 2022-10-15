package com.johnlewis.test.domain.usecase.products

import com.johnlewis.test.domain.model.DomainProductsModel
import com.johnlewis.test.domain.repositories.DomainProductsRepository
import com.johnlewis.test.domain.sealed.DomainSealedResponse
import com.johnlewis.test.domain.usecase.BaseUseCase
import javax.inject.Inject

class GetProductListUseCase @Inject constructor(
    private val domainProductsRepository: DomainProductsRepository
) : BaseUseCase<DomainSealedResponse<List<DomainProductsModel>>>() {
    override suspend fun execute(): DomainSealedResponse<List<DomainProductsModel>> {
        return domainProductsRepository.getAllProducts()
    }
}