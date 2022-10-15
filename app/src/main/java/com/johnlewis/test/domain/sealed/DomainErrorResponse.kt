package com.johnlewis.test.domain.sealed

data class DomainErrorResponse(
    val errorCode: Int?,
    val errorMessage: String?
)