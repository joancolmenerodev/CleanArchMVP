package com.joancolmenerodev.cleanarch.feature.coinlist.page

import android.content.Context
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.joancolmenerodev.cleanarch.R
import com.joancolmenerodev.cleanarch.base.Page
import com.joancolmenerodev.cleanarch.base.UIElement

class CoinListPage(context: Context) : Page(context = context) {

    private val recyclerView = UIElement(withId(R.id.rv_crypto_currency_list))
    private val linearMainActivity = UIElement(withId(R.id.linear_main_activity))

    override fun at() {
        linearMainActivity.isDisplayed()
    }

    fun isRecyclerViewFilled(){
        recyclerView.clickItemAtPosition(FIRST_POSITION_RECYCLER_VIEW)
    }


    companion object {
        const val FIRST_POSITION_RECYCLER_VIEW = 0
    }
}