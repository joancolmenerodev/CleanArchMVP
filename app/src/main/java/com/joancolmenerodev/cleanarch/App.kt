package com.joancolmenerodev.cleanarch

import android.app.Application
import com.joancolmenerodev.base.di.retrofitModule
import com.joancolmenerodev.cleanarch.di.AppInject
import com.joancolmenerodev.di.DataInject
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

class App : Application(), KodeinAware {

    private val contextModule = Kodein.Module("contextModule") {
        bind<App>() with provider { this@App }
    }

    override val kodein by Kodein.lazy {

        import(contextModule)
        import(retrofitModule)
        AppInject.modules().forEach { import(it) }

    }
}