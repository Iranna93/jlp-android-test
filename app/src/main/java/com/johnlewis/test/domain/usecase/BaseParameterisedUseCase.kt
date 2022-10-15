package com.johnlewis.test.domain.usecase

abstract class BaseParameterisedUseCase<in P, R> {

    abstract suspend fun execute(parameters: P): R

}