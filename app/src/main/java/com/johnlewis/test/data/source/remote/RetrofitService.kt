package com.johnlewis.test.data.source.remote

import com.johnlewis.test.data.entities.products.ProductsResponse
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {
    @GET
    suspend fun getProducts(@Url url: String): ProductsResponse // TODO We can pass the paramters
//    @GET("photos/{id}")
//    fun getProductDetails(@Path("id") id: Long): Single<Photo>
}
