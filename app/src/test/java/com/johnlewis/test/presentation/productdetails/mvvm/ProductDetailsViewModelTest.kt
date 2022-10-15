package com.johnlewis.test.presentation.productdetails.mvvm

import com.johnlewis.test.domain.model.DomainProductDetails
import com.johnlewis.test.domain.model.DomainProductsModel
import com.johnlewis.test.domain.sealed.DomainErrorResponse
import com.johnlewis.test.domain.sealed.DomainSealedResponse
import com.johnlewis.test.presentation.products.mvvm.ProductsModel
import com.johnlewis.test.presentation.products.mvvm.ProductsViewModel
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class ProductDetailsViewModelTest {
    private val dispatcher = UnconfinedTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    private fun prepareMockData(): DomainProductDetails {
        return DomainProductDetails(
            productId = "3218074",
            title = "Bosch Serie 2 SMV40C30GB Fully Integrated Dishwasher",
            productInformation = "details.details.productInformation",
            price = DomainProductDetails.Price(
                was = "",
                then1 = "",
                then2 = "",
                now = "234",
                uom = "",
                currency = "GBP"
            ),
            code = "1123123123",
            images = DomainProductDetails.Images(
                altText = "details.media.images.altText",
                urls = ArrayList()
            ),
            additionalServices = DomainProductDetails.AdditionalServices(
                includedServices = ArrayList(),
                optionalServices = ArrayList()
            ),
            attributes = arrayListOf(
                DomainProductDetails.Attributes(
                    value = "attributes.value",
                    values = arrayListOf(),
                    multivalued = false,
                    id = "",
                    name = "attributes.name",
                    toolTip = "as",
                    uom = ""
                ),
                DomainProductDetails.Attributes(
                    value = "attributes.value",
                    values = arrayListOf(),
                    multivalued = false,
                    id = "",
                    name = "attributes.name",
                    toolTip = "as",
                    uom = ""
                ),
                DomainProductDetails.Attributes(
                    value = "attributes.value",
                    values = arrayListOf(),
                    multivalued = false,
                    id = "",
                    name = "attributes.name",
                    toolTip = "as",
                    uom = ""
                ),


                )
        )
    }

    private fun verifyErrorProductDetailsData(
        mockProductData: DomainProductDetails,
        resultData: DomainProductDetails,
    ) {
        assertEquals(mockProductData.productId, resultData.productId)
        assertEquals(mockProductData.code, resultData.code)
        assertEquals(3, resultData.attributes.size)
    }

    @Test
    fun productDetailsViewModel_RequestProductDetails_Success() = runTest {
        val modelProductMock = mockk<ProductDetailsModel>()
        val mockData = prepareMockData()
        val testScope = CoroutineScope(dispatcher)
        val productId = "3218074"
        coEvery {
            modelProductMock.getProductDetails(productId = productId)
        } returns DomainSealedResponse.Success(data = mockData)

        val viewModel = ProductDetailsViewModel(
            productsModel = modelProductMock
        )

        var initialResultList: List<ProductDetailsViewModel.CurrentUIState>? = null

        testScope.launch {
            viewModel.acceptNewIntention(
                intention = ProductDetailsViewModel.ProductDetailsIntention.RequestProductDetails(
                    productId = productId
                )
            )
            initialResultList = viewModel.productStateFlow.take(2).toList()
        }.join()
        assertEquals(true, initialResultList?.isNotEmpty())

        initialResultList?.let { resultsList ->
            assertEquals(
                true,
                resultsList[0] is ProductDetailsViewModel.CurrentUIState.NotLoaded
            )
            assertEquals(
                true,
                resultsList[1] is ProductDetailsViewModel.CurrentUIState.ShowProductDetails
            )

            val resultData =
                resultsList[1] as ProductDetailsViewModel.CurrentUIState.ShowProductDetails

            verifyErrorProductDetailsData(
                mockProductData = mockData,
                resultData = resultData.data,
            )
        }
    }

    @Test
    fun productDetailsViewModel_RequestProductDetails_NotLoaded() = runTest {
        val modelProductMock = mockk<ProductDetailsModel>()

        val testScope = CoroutineScope(dispatcher)
        val productId = "3218074"
        coEvery {
            modelProductMock.getProductDetails(productId = productId)
        } returns DomainSealedResponse.Success(data = null)

        val viewModel = ProductDetailsViewModel(
            productsModel = modelProductMock
        )

        var initialResult: ProductDetailsViewModel.CurrentUIState? = null

        testScope.launch {
            viewModel.acceptNewIntention(
                intention = ProductDetailsViewModel.ProductDetailsIntention.RequestProductDetails(
                    productId = productId
                )
            )

        }.join()
        initialResult = viewModel.productStateFlow.value

        assertEquals(
            true,
            initialResult is ProductDetailsViewModel.CurrentUIState.NotLoaded
        )
    }

    @Test
    fun productDetailsViewModel_RequestProductDetails_Error() = runTest {
        val modelProductMock = mockk<ProductDetailsModel>()
        val mockData = prepareMockData()
        val testScope = CoroutineScope(dispatcher)
        val productId = "3218074"
        coEvery {
            modelProductMock.getProductDetails(productId = productId)
        } returns DomainSealedResponse.Error(
            data = null,
            error = DomainErrorResponse(errorCode = 12, errorMessage = "Testing")
        )

        val viewModel = ProductDetailsViewModel(
            productsModel = modelProductMock
        )

        var initialResultList: List<ProductDetailsViewModel.CurrentUIState>? = null

        testScope.launch {
            viewModel.acceptNewIntention(
                intention = ProductDetailsViewModel.ProductDetailsIntention.RequestProductDetails(
                    productId = productId
                )
            )
            initialResultList = viewModel.productStateFlow.take(2).toList()
        }.join()
        assertEquals(true, initialResultList?.isNotEmpty())

        initialResultList?.let { resultsList ->
            assertEquals(
                true,
                resultsList[0] is ProductDetailsViewModel.CurrentUIState.NotLoaded
            )
            assertEquals(
                true,
                resultsList[1] is ProductDetailsViewModel.CurrentUIState.Error
            )
        }
    }

}