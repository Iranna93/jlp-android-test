package com.johnlewis.test.data.repositories

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.johnlewis.test.domain.repositories.DomainProductsRepository
import com.johnlewis.test.data.boundary.DomainMapper
import com.johnlewis.test.data.entities.productdetails.DetailsData
import com.johnlewis.test.data.entities.productdetails.ProductDetails
import com.johnlewis.test.data.entities.products.ProductsResponse
import com.johnlewis.test.data.source.remote.RetrofitService
import com.johnlewis.test.data.utils.AssetUtils.getJsonDataFromAsset
import com.johnlewis.test.domain.model.DomainProductDetails
import com.johnlewis.test.domain.model.DomainProductsModel
import com.johnlewis.test.domain.sealed.DomainErrorResponse
import com.johnlewis.test.domain.sealed.DomainSealedResponse

class ProductsRepositoryImpl(
    private val applicationContext: Context,
    private val retrofitService: RetrofitService,
    private val domainMapper: DomainMapper
) : DomainProductsRepository {
    override suspend fun getAllProducts(): DomainSealedResponse<List<DomainProductsModel>> {
        val jsonFileString = getJsonDataFromAsset(applicationContext, "data.json")
        jsonFileString?.let {
            val productType = object : TypeToken<ProductsResponse>() {}.type
            val productResponse: ProductsResponse = Gson().fromJson(jsonFileString, productType)
            return DomainSealedResponse.Success(data = domainMapper.mapDomainProduct(productResponse))
        } ?: kotlin.run {
            return DomainSealedResponse.Error(
                error = DomainErrorResponse(
                    errorCode = 123,
                    errorMessage = "Unable to load the data. Please try again"
                )
            )
        }

        //return domainMapper.mapDomainProduct(retrofitService.getProducts(Constants.PRODUCT_URL)) // TODO : Here we can get the url or params from domain
    }

    override suspend fun getProductDetails(productId: String): DomainSealedResponse<DomainProductDetails?> {
        println("**** getProductDetails => $productId")
        val jsonFileString = getJsonDataFromAsset(applicationContext, "data2.json")
        jsonFileString?.let {
            val productType = object : TypeToken<ProductDetails>() {}.type
            val productResponse: ProductDetails = Gson().fromJson(jsonFileString, productType)
            var detailsData: DetailsData? = null
            for (item in productResponse.detailsData) {
                if (item.productId == productId) {
                    detailsData = item
                    break
                }
            }

            println("**** getProductDetails => details $detailsData")
            detailsData?.let {
                return DomainSealedResponse.Success(
                    data = domainMapper.mapDomainProductDetail(it)
                )
            } ?: kotlin.run {
                return DomainSealedResponse.Error(
                    error = DomainErrorResponse(
                        errorCode = 321,
                        errorMessage = "Unable to load the data. Please try again"
                    )
                )
            }
        } ?: kotlin.run {
            return DomainSealedResponse.Error(
                error = DomainErrorResponse(
                    errorCode = 123,
                    errorMessage = "Unable to load the data. Please try again"
                )
            )
        }
    }
}