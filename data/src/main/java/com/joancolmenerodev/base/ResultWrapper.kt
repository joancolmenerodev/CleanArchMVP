package com.joancolmenerodev.base

sealed class ResultWrapper<out T> {
    data class Success<out T: Any>(val value: T) : ResultWrapper<T>()
    data class Failure<out T: Any>(val failure: Throwable): ResultWrapper<T>()

    fun <T: Any> just(t: T): ResultWrapper<T> = Success(t)
    fun <T: Any> raise(t: Throwable): ResultWrapper<Throwable> = Failure(t)

}