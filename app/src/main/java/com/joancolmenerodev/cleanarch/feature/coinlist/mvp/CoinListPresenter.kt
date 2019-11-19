package com.joancolmenerodev.cleanarch.feature.coinlist.mvp

import com.joancolmenerodev.cleanarch.base.AbstractPresenter
import com.joancolmenerodev.cleanarch.base.threading.DefaultDisparcherProvider
import com.joancolmenerodev.cleanarch.base.threading.DispatcherProvider
import com.joancolmenerodev.cleanarch.feature.coinlist.usecase.GetCoinListUseCase
import kotlinx.coroutines.withContext

class CoinListPresenter(
    private val getCoinListUseCase: GetCoinListUseCase,
    private val uiContextProvider: DispatcherProvider = DefaultDisparcherProvider()
) :
    AbstractPresenter<CoinListContract.View>(uiContextProvider), CoinListContract.Presenter {

    override fun loadResults() {
        //this will run in Main by default (unless is for testing purposes)
        perform {
            view?.showProgressBar(isVisible = true)
            //Change thread to IO to make the api call
            withContext(uiContextProvider.io()) {
                getCoinListUseCase.execute()
            }.fold({
                view?.showProgressBar(isVisible = false)
                view?.showError(it.message)
            }, {
                view?.showProgressBar(isVisible = false)
                view?.showResults(it)
            })
        }
    }

    override fun onCoinClicked(cryptoId: Int) {
        view?.navigateToCoinDetail(cryptoId = cryptoId)
    }
}