package com.joancolmenerodev.cleanarch.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.IdlingResource
import androidx.test.espresso.intent.rule.IntentsTestRule
import androidx.test.platform.app.InstrumentationRegistry
import com.jakewharton.espresso.OkHttp3IdlingResource
import okhttp3.OkHttpClient
import org.junit.After
import org.junit.Before
import org.junit.Rule

abstract class BaseTest<T : Activity> {

    abstract fun getTestActivity(): IntentsTestRule<T>

    val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    private val resource : IdlingResource = OkHttp3IdlingResource.create("OkHttp", OkHttpClient())

    fun at(page: Page) {
        page.at()
    }

    @Rule
    @JvmField
    var activityTestRule = this.getTestActivity()

    @Before
    open fun setUp() {
        IdlingRegistry.getInstance().register(resource)
    }

    fun launchActivity(intent: Intent?){
        getTestActivity().launchActivity(intent)
    }

    @After
    fun tearDown() {
        activityTestRule.finishActivity()
        IdlingRegistry.getInstance().unregister(resource)
    }

}