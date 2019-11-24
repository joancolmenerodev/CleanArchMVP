package com.joancolmenerodev.cleanarch.base

import android.content.Context
import androidx.annotation.StringRes

abstract class Page (private val context: Context) {

    abstract fun at()

    fun getString(@StringRes id: Int): String {
        return context.getString(id)
    }
}