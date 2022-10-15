package com.johnlewis.test.data.entities.products

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("showInStockOnly") var showInStockOnly: Boolean? = null,
    @SerializedName("isPersonalised") var isPersonalised: Boolean? = null,
    @SerializedName("products") var products: ArrayList<Products> = arrayListOf(),
    @SerializedName("facets") var facets: ArrayList<Facets> = arrayListOf(),
    @SerializedName("results") var results: Int? = null,
    @SerializedName("pagesAvailable") var pagesAvailable: Int? = null,
    @SerializedName("crumbs") var crumbs: ArrayList<Crumbs> = arrayListOf(),
    @SerializedName("pageInformation") var pageInformation: PageInformation? = PageInformation(),
    @SerializedName("baseFacetId") var baseFacetId: String? = null
)