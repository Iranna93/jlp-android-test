@file:OptIn(ExperimentalCoroutinesApi::class)

package com.johnlewis.test.presentation.products.mvvm

import com.johnlewis.test.domain.model.DomainProductsModel
import com.johnlewis.test.domain.sealed.DomainErrorResponse
import com.johnlewis.test.domain.sealed.DomainSealedResponse
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class ProductsViewModelTest {
    private val dispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private fun prepareMockData(): List<DomainProductsModel> {
        return listOf(
            DomainProductsModel(
                productId = "3218074",
                type = "standard",
                title = "Bosch Serie 2 SMV40C30GB Fully Integrated Dishwasher",
                code = "88711106",
                averageRating = 0.1,
                reviews = 1,
                image = "/bosch-serie-2-smv40c30gb-fully-integrated-dishwasher/p1955287",
                alternativeImageUrls = ArrayList<String>(),
                outOfStock = false,
                isAvailableToOrder = true,
                brand = "Bosch",
                ageRestriction = 2,
                price = DomainProductsModel.Price(
                    was = "",
                    then1 = "",
                    then2 = "",
                    now = "334",
                    uom = "",
                    currency = "GBP"
                )
            ),
            DomainProductsModel(
                productId = "3218071",
                type = "standard",
                title = "Bosch Serie 2 SMV40C30GB Fully ",
                code = "88711106",
                averageRating = 0.1,
                reviews = 1,
                image = "/bosch-serie-2-smv40c30gb-fully-integrated-dishwasher/p1955287",
                alternativeImageUrls = ArrayList<String>(),
                outOfStock = false,
                isAvailableToOrder = true,
                brand = "Bosch",
                ageRestriction = 2,
                price = DomainProductsModel.Price(
                    was = "",
                    then1 = "",
                    then2 = "",
                    now = "334",
                    uom = "",
                    currency = "GBP"
                )
            )
        )
    }

    private fun verifyErrorProductData(
        mockProductData: List<DomainProductsModel>,
        resultData: List<DomainProductsModel>,
    ) {
        assertEquals(2, resultData.size)
        assertEquals(mockProductData[0].productId, resultData[0].productId)
        assertEquals(mockProductData[0].code, resultData[0].code)
    }

    @Test
    fun productViewModel_RequestProductList_Success() = runTest {
        val modelProductMock = mockk<ProductsModel>()
        val mockData = prepareMockData()
        val testScope = CoroutineScope(dispatcher)

        coEvery {
            modelProductMock.getProductsList()
        } returns DomainSealedResponse.Success(data = mockData)

        val viewModel = ProductsViewModel(
            productsModel = modelProductMock
        )

        var initialResultList: List<ProductsViewModel.CurrentUIState>? = null

        testScope.launch {
            viewModel.acceptNewIntention(
                intention = ProductsViewModel.ProductIntention.RequestProductList
            )
            initialResultList = viewModel.productStateFlow.take(2).toList()
        }.join()
        assertEquals(true, initialResultList?.isNotEmpty())

        initialResultList?.let { resultsList ->
            assertEquals(
                true,
                resultsList[0] is ProductsViewModel.CurrentUIState.NotLoaded
            )
            assertEquals(true, resultsList[1] is ProductsViewModel.CurrentUIState.ShowProductList)

            val resultData =
                resultsList[1] as ProductsViewModel.CurrentUIState.ShowProductList

            verifyErrorProductData(
                mockProductData = mockData,
                resultData = resultData.data,
            )
        }
    }

    @Test
    fun productViewModel_RequestProductList_NotLoaded() = runTest {
        val modelProductMock = mockk<ProductsModel>()
        val testScope = CoroutineScope(dispatcher)

        coEvery {
            modelProductMock.getProductsList()
        } returns DomainSealedResponse.Success(data = emptyList())

        val viewModel = ProductsViewModel(
            productsModel = modelProductMock
        )

        var initialResultList: ProductsViewModel.CurrentUIState? = null

        testScope.launch {
            viewModel.acceptNewIntention(
                intention = ProductsViewModel.ProductIntention.RequestProductList
            )
            initialResultList = viewModel.productStateFlow.value
        }.join()

        assertEquals(true, initialResultList is ProductsViewModel.CurrentUIState.NotLoaded)
    }

    @Test
    fun productViewModel_RequestProductList_Error() = runTest {
        val modelProductMock = mockk<ProductsModel>()
        val testScope = CoroutineScope(dispatcher)

        coEvery {
            modelProductMock.getProductsList()
        } returns DomainSealedResponse.Error(
            data = emptyList(),
            error = DomainErrorResponse(errorMessage = "Testing", errorCode = 11)
        )

        val viewModel = ProductsViewModel(
            productsModel = modelProductMock
        )

        var initialResultList: List<ProductsViewModel.CurrentUIState>? = null

        testScope.launch {
            viewModel.acceptNewIntention(
                intention = ProductsViewModel.ProductIntention.RequestProductList
            )
            initialResultList = viewModel.productStateFlow.take(2).toList()
        }.join()
        assertEquals(true, initialResultList?.isNotEmpty())

        initialResultList?.let { resultsList ->
            assertEquals(
                true,
                resultsList[0] is ProductsViewModel.CurrentUIState.NotLoaded
            )
            assertEquals(
                true,
                resultsList[1] is ProductsViewModel.CurrentUIState.Error
            )
        }
    }

    @Test
    fun productViewModel_triggerProductDetails_Success() = runTest {
        val modelProductMock = mockk<ProductsModel>()
        val testScope = CoroutineScope(dispatcher)
        val productId = "3218074"

        val viewModel = ProductsViewModel(
            productsModel = modelProductMock
        )

        var initialResultList: ProductsViewModel.CurrentUIState? = null

        testScope.launch {
            viewModel.acceptNewIntention(
                intention = ProductsViewModel.ProductIntention.RequestProductDetails(productId = productId)
            )
        }.join()

        initialResultList = viewModel.productStateFlow.value

        assertEquals(true, initialResultList is ProductsViewModel.CurrentUIState.ShowProductDetails)

        val resultProductId =
            initialResultList as ProductsViewModel.CurrentUIState.ShowProductDetails

        assertEquals(productId, resultProductId.productId)
    }
}