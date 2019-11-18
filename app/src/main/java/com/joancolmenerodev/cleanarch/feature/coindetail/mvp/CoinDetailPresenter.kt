package com.joancolmenerodev.cleanarch.feature.coindetail.mvp

import com.joancolmenerodev.cleanarch.base.AbstractPresenter
import com.joancolmenerodev.features.coindetail.usecase.GetCoinDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoinDetailPresenter(private val getCoinDetailUseCase: GetCoinDetailUseCase) :
    AbstractPresenter<CoinDetailContract.View>(), CoinDetailContract.Presenter {
    override fun loadData(cryptoId: Int?) {
        view?.showProgressBar(isVisible = true)
        launch {
            withContext(Dispatchers.IO) {
                getCoinDetailUseCase.execute(cryptoId = cryptoId)
            }.fold({
                view?.showProgressBar(isVisible = false)
                view?.showError("Something here")
            }, {
                view?.showProgressBar(isVisible = false)
                view?.displayData(it)
            })
        }
    }
}