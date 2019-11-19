package com.joancolmenerodev.cleanarch.feature.coinlist.mvp

import com.joancolmenerodev.cleanarch.base.AbstractPresenter
import com.joancolmenerodev.cleanarch.feature.coinlist.usecase.GetCoinListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoinListPresenter(private val getCoinListUseCase: GetCoinListUseCase) :
    AbstractPresenter<CoinListContract.View>(), CoinListContract.Presenter {

    override fun loadResults() {
        //this will run in Main by default (unless is for testing purposes)
        launch {
            view?.showProgressBar(isVisible = true)
            //Change thread to IO to make the api call
            withContext(Dispatchers.IO) {
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