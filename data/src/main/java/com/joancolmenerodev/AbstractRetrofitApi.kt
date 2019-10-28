package com.joancolmenerodev

import com.joancolmenerodev.base.ResultWrapper

abstract class AbstractRetrofitApi {
    inline fun <reified T : Any> execute(requestFunc: () -> T): ResultWrapper<T> =
        try {
            ResultWrapper.Success(requestFunc.invoke())
        } catch (exception: Exception) {
            ResultWrapper.Failure(exception)
        }
}