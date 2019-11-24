package com.joancolmenerodev.cleanarch.feature.coindetail.page

import android.content.Context
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.joancolmenerodev.cleanarch.R
import com.joancolmenerodev.cleanarch.base.Page
import com.joancolmenerodev.cleanarch.base.UIElement

class CoinDetailPage (context: Context) : Page(context = context) {

    private val relativeParentDetail = UIElement(withId(R.id.relative_parent_detail))
    private val cryptoName = UIElement(withId(R.id.tv_cryptoName))

    override fun at() {
        relativeParentDetail.isDisplayed()
    }

    fun cryptoNameText(text: String) {
        cryptoName.withText(text)
    }
}