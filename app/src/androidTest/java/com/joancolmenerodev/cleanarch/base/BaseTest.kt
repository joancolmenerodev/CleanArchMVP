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
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance
import org.kodein.di.generic.kcontext

abstract class BaseTest<T : Activity> : KodeinAware {

    abstract fun getTestActivity(): IntentsTestRule<T>
    val context: Context = InstrumentationRegistry.getInstrumentation().targetContext

    override val kodein : Kodein by kodein(context)
    private val client : OkHttpClient by instance()

    private val resource : IdlingResource = OkHttp3IdlingResource.create("OkHttp", client)

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