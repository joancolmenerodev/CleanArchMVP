package com.joancolmenerodev.cleanarch.base

import com.joancolmenerodev.cleanarch.base.threading.DefaultDisparcherProvider
import com.joancolmenerodev.cleanarch.base.threading.DispatcherProvider
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


//abstract class AbstractPresenter<T : PresenterView>(private val uiContext: CoroutineContextProvider = CoroutineContextProvider()) :
//or
//abstract class AbstractPresenter<T : PresenterView>(private val uiContext: CoroutineContext = Dispatchers.Main) :
//    BasePresenter<T>, CoroutineScope {
abstract class AbstractPresenter<T : PresenterView>(private val uiContext: DispatcherProvider = DefaultDisparcherProvider()) :
    BasePresenter<T> {
    private val jobs = mutableListOf<Job>()
    var view: T? = null

    override fun onViewDestroyed() {
        this.view = null
        jobs.clear()
    }

    override fun onViewReady(view: T) {
        this.view = view
    }

    protected fun perform(block: suspend CoroutineScope.(T) -> Unit) = view?.let {
        jobs.add(
            CoroutineScope(context = uiContext.main() + CoroutineExceptionHandler { _, error -> throw error }).launch {
                block(
                    it
                )
            }
        )
    } ?: throw NotImplementedError("viewNotAttached")
}