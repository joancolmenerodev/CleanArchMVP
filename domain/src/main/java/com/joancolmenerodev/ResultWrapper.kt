package com.joancolmenerodev

sealed class ResultWrapper<out T> {
    data class Success<out T : Any>(val value: T) : ResultWrapper<T>()
    data class Failure<out T : Any>(val failure: Throwable) : ResultWrapper<T>()

    inline fun <B> fold(ifFailure: (Throwable) -> B, ifSuccess: (T) -> B): B =
        when (this) {
            is Failure -> ifFailure(failure)
            is Success -> ifSuccess(value)
        }

    companion object {
        fun <T : Any> just(t: T): ResultWrapper<T> = Success(t)
        fun <T : Any> raise(t: Throwable): ResultWrapper<Throwable> = Failure(t)
    }
}
