package com.joancolmenerodev.cleanarch.extensions.view

import android.view.View

fun View.setVisibile(isVisible: Boolean) {
    when (isVisible) {
        true -> this.visibility = View.VISIBLE
        else -> this.visibility = View.GONE
    }
}