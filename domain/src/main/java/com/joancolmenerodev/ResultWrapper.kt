package com.joancolmenerodev

sealed class ResultWrapper<out T> {
    data class Success<out T : Any>(val value: T) : ResultWrapper<T>()
    data class Failure(val failure: Throwable) : ResultWrapper<Nothing>()

    inline fun <B> fold(ifFailure: (Throwable) -> B, ifSuccess: (T) -> B): B =
        when (this) {
            is Failure -> ifFailure(failure)
            is Success -> ifSuccess(value)
        }

    fun isFailure() = this.failureOrNull() != null
    fun isSuccess() = this.getOrDefault { null } != null

    companion object {
        fun <T : Any> just(t: T): ResultWrapper<T> = Success(t)
        fun <T : Any> raise(t: Throwable): ResultWrapper<Throwable> = Failure(t)
    }
}

inline fun <T> ResultWrapper<T>.getOrDefault(defaultValue: (err: Throwable) -> T): T {
    return fold(defaultValue, { it })
}

fun ResultWrapper<*>.failureOrNull(): Throwable? = (this as? ResultWrapper.Failure)?.failure
