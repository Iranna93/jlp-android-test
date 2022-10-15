package com.johnlewis.test.presentation

import java.util.*

object CurrencyUtils {
    fun getCurrencySymbol(currencyCode: String): String {
        val currency = Currency.getInstance(currencyCode)
        return currency.symbol
    }
}