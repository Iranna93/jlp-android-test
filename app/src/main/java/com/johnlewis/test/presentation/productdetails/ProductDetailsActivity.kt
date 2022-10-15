package com.johnlewis.test.presentation.productdetails

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.res.stringResource
import com.johnlewis.test.presentation.productdetails.compose.ProductDetailsScreen
import com.johnlewis.test.presentation.productdetails.mvvm.ProductDetailsModel
import com.johnlewis.test.presentation.productdetails.mvvm.ProductDetailsViewModel
import com.johnlewis.test.presentation.products.compose.ProductListScreen
import com.johnlewis.test.presentation.products.mvvm.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailsActivity : AppCompatActivity() {

    private val productDetailsViewModel by viewModels<ProductDetailsViewModel>()

    companion object {
        const val EXTRA_PRODUCT_ID = "ProductId"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ProductDetailsScreen.initialise(
                    currentUIStateFlow = productDetailsViewModel.productStateFlow,
                    intentionListener = productDetailsViewModel
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val productId = intent.getStringExtra(EXTRA_PRODUCT_ID)
        println("**** Product Id $productId")
        productId?.let {
            productDetailsViewModel.acceptNewIntention(
                ProductDetailsViewModel.ProductDetailsIntention.RequestProductDetails(
                    productId = it
                )
            )
        }
    }
}