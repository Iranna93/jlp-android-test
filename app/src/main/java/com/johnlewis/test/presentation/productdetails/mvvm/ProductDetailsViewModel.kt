package com.johnlewis.test.presentation.productdetails.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.johnlewis.test.domain.model.DomainProductDetails
import com.johnlewis.test.domain.sealed.DomainSealedResponse
import com.johnlewis.test.presentation.productdetails.compose.ProductDetailsActionListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductDetailsViewModel @Inject constructor(
    private val productsModel: ProductDetailsModel
) : ViewModel(), ProductDetailsActionListener {

    sealed class ProductDetailsIntention {
        data class RequestProductDetails(
            val productId: String
        ) : ProductDetailsIntention()
    }

    sealed class CurrentUIState {
        object NotLoaded : CurrentUIState()
        object Loading : CurrentUIState()
        data class ShowProductDetails(val data: DomainProductDetails) : CurrentUIState()
        data class Error(val errorCode: Int?, val errorMessages: String?) : CurrentUIState()
    }

    // StateFlows
    private val _productsStateFlow = MutableStateFlow<CurrentUIState>(
        CurrentUIState.NotLoaded
    )

    val productStateFlow: StateFlow<CurrentUIState> = _productsStateFlow

    private fun triggerProductList(productId: String) {
        viewModelScope.launch() {
            _productsStateFlow.emit(CurrentUIState.Loading)
            when (val response = productsModel.getProductDetails(productId = productId)) {
                is DomainSealedResponse.Success -> {
                    response.data?.let {
                        _productsStateFlow.emit(CurrentUIState.ShowProductDetails(data = it))
                    } ?: kotlin.run {
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

    override fun acceptNewIntention(intention: ProductDetailsIntention) {
        if (intention is ProductDetailsIntention.RequestProductDetails) {
            triggerProductList(productId = intention.productId)
        }
    }
}