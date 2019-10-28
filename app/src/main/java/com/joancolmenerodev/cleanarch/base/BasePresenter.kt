package com.joancolmenerodev.cleanarch.base

interface BasePresenter<T> {
    fun onViewReady(view: T)
    fun onViewDestroyed()
}