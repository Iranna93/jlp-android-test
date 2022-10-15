package com.johnlewis.test.presentation.productdetails.compose

import com.johnlewis.test.presentation.productdetails.mvvm.ProductDetailsViewModel


interface ProductDetailsActionListener {
    fun acceptNewIntention(intention: ProductDetailsViewModel.ProductDetailsIntention)
}