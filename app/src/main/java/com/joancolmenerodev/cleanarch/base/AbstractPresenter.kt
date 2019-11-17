package com.joancolmenerodev.cleanarch.base

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


//abstract class AbstractPresenter<T : PresenterView>(private val uiContext: CoroutineContextProvider = CoroutineContextProvider()) :
//or
//abstract class AbstractPresenter<T : PresenterView>(private val uiContext: CoroutineContext = Dispatchers.Main) :
//    BasePresenter<T>, CoroutineScope {
abstract class AbstractPresenter<T : PresenterView>(private val uiContext: CoroutineContext = Dispatchers.Main) :
    BasePresenter<T>, CoroutineScope {
    private var job = Job()
    var view: T? = null

    override val coroutineContext: CoroutineContext
        get() = uiContext + job

    override fun onViewDestroyed() {
        this.view = null
        this.job.cancel()
    }

    override fun onViewReady(view: T) {
        this.view = view
    }
}