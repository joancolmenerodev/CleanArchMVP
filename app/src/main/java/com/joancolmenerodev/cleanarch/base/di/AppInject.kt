package com.joancolmenerodev.cleanarch.base.di

import com.joancolmenerodev.cleanarch.feature.coinlist.mvp.CoinListContract
import com.joancolmenerodev.cleanarch.feature.coinlist.mvp.CoinListPresenter
import com.joancolmenerodev.di.DataInject
import com.joancolmenerodev.di.DomainInject
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

object AppInject {

    fun modules() : List<Kodein.Module> = ArrayList<Kodein.Module>().apply {
        addAll(DataInject.modules())
        addAll(DomainInject.modules())
        add(presenterModules)
    }

    private val presenterModules = Kodein.Module("presenterModule") {
        bind<CoinListContract.Presenter>() with singleton { CoinListPresenter(instance()) }
    }
}