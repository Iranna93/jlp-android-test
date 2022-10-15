package com.johnlewis.test.presentation.products.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnlewis.test.domain.model.DomainProductsModel
import com.johnlewis.test.domain.sealed.DomainSealedResponse
import com.johnlewis.test.presentation.products.compose.ProductActionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductsViewModel @Inject constructor(
    private val productsModel: ProductsModel
) : ViewModel(), ProductActionListener {

    sealed class ProductIntention {
        object RequestProductList : ProductIntention()
        data class RequestProductDetails(
            val productId: String
        ) : ProductIntention()
    }

    sealed class CurrentUIState {
        object NotLoaded : CurrentUIState()
        object Loading : CurrentUIState()
        data class ShowProductList(val data: List<DomainProductsModel>) : CurrentUIState()
        data class Error(val errorCode: Int?, val errorMessages: String?) : CurrentUIState()
        data class ShowProductDetails(val productId: String) : CurrentUIState()
    }

    // StateFlows
    private val _productsStateFlow = MutableStateFlow<CurrentUIState>(
        CurrentUIState.NotLoaded
    )

    val productStateFlow: StateFlow<CurrentUIState> = _productsStateFlow

    private fun triggerProductList() {
        viewModelScope.launch() {
            _productsStateFlow.emit(CurrentUIState.Loading)
            when (val response = productsModel.getProductsList()) {
                is DomainSealedResponse.Success -> {
                    if (!response.data.isNullOrEmpty()) {
                        _productsStateFlow.emit(CurrentUIState.ShowProductList(data = response.data))
                    } else {
                        _productsStateFlow.emit(CurrentUIState.NotLoaded)
                    }
                }
                is DomainSealedResponse.Error -> {
                    _productsStateFlow.emit(
                        CurrentUIState.Error(
                            response.error?.errorCode,
                            response.error?.errorMessage
                        )
                    )
                }
            }
        }
    }

    private fun triggerProductDetails(productId: String) {
        viewModelScope.launch() {
            _productsStateFlow.emit(CurrentUIState.ShowProductDetails(productId = productId))
        }
    }

    override fun acceptNewIntention(intention: ProductIntention) {
        when (intention) {
            is ProductIntention.RequestProductList -> {
                triggerProductList()
            }
            is ProductIntention.RequestProductDetails -> {
                triggerProductDetails(intention.productId)
            }
        }
    }
}