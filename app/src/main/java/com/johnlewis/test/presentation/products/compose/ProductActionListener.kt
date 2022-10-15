package com.johnlewis.test.presentation.products.compose

import com.johnlewis.test.presentation.products.mvvm.ProductsViewModel


interface ProductActionListener {
    fun acceptNewIntention(intention: ProductsViewModel.ProductIntention)
}