package com.joancolmenerodev.cleanarch.base

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

//class to be discused, to use this class on AbstractPresenter
open class CoroutineContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
    open val io: CoroutineContext by lazy { Dispatchers.IO }
}