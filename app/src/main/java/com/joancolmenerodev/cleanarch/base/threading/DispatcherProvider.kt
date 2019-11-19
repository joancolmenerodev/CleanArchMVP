package com.joancolmenerodev.cleanarch.base.threading

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface DispatcherProvider {

    fun main(): CoroutineDispatcher = Dispatchers.Main
    fun default(): CoroutineDispatcher = Dispatchers.Default
    fun io(): CoroutineDispatcher = Dispatchers.IO
    fun unconfined(): CoroutineDispatcher = Dispatchers.Unconfined

}

class DefaultDisparcherProvider : DispatcherProvider

class TestDispatcherProvider : DispatcherProvider{
    override fun default(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }

    override fun io(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }

    override fun main(): CoroutineDispatcher {
        return Dispatchers.Unconfined
    }
}
