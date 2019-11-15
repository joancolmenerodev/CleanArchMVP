package com.joancolmenerodev.di

import com.joancolmenerodev.cleanarch.feature.coinlist.usecase.GetCoinListUseCase
import com.joancolmenerodev.features.coindetail.usecase.GetCoinDetailUseCase
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

object DomainInject {

    fun modules() = listOf<Kodein.Module>(repositoryModule)

    private val repositoryModule = Kodein.Module("usecaseModule") {
        bind<GetCoinListUseCase>() with singleton { GetCoinListUseCase(instance()) }
        bind<GetCoinDetailUseCase>() with singleton { GetCoinDetailUseCase(instance()) }
    }

}