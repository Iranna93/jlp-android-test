package com.johnlewis.test.presentation.products

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import com.johnlewis.test.presentation.products.compose.ProductListScreen
import com.johnlewis.test.presentation.products.mvvm.ProductsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductsActivity : AppCompatActivity() {

    private val productsViewModel: ProductsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                ProductListScreen.initialise(
                    currentUIStateFlow = productsViewModel.productStateFlow,
                    intentionListener = productsViewModel
                )
            }
        }
    }

    override fun onResume() {
        super.onResume()
        productsViewModel.acceptNewIntention(ProductsViewModel.ProductIntention.RequestProductList)
    }

}