package com.joancolmenerodev.di

import com.joancolmenerodev.feature.coindetail.repository.CoinDetailRepositoryImpl
import com.joancolmenerodev.feature.coinlist.CoinListRepositoryImpl
import com.joancolmenerodev.features.coindetail.repository.CoinDetailRepository
import com.joancolmenerodev.features.coinlist.repository.CoinListRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

object DataInject {

    fun modules() = listOf<Kodein.Module>(repositoryModule)

    private val repositoryModule = Kodein.Module("repositoryModule") {
        bind<CoinDetailRepository>() with singleton { CoinDetailRepositoryImpl(instance()) }
        bind<CoinListRepository>() with singleton { CoinListRepositoryImpl(instance()) }
    }

}