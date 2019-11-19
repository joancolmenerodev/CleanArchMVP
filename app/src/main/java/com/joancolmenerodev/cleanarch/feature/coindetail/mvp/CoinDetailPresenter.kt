package com.joancolmenerodev.cleanarch.feature.coindetail.mvp

import com.joancolmenerodev.cleanarch.base.AbstractPresenter
import com.joancolmenerodev.cleanarch.base.threading.DefaultDisparcherProvider
import com.joancolmenerodev.cleanarch.base.threading.DispatcherProvider
import com.joancolmenerodev.features.coindetail.usecase.GetCoinDetailUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoinDetailPresenter(
    private val getCoinDetailUseCase: GetCoinDetailUseCase,
    private val uiContextProvider: DispatcherProvider = DefaultDisparcherProvider()
) :
    AbstractPresenter<CoinDetailContract.View>(), CoinDetailContract.Presenter {
    override fun loadData(cryptoId: Int?) {
        view?.showProgressBar(isVisible = true)
        perform {
            withContext(uiContextProvider.io()) {
                getCoinDetailUseCase.execute(cryptoId = cryptoId)
            }.fold({
                view?.showProgressBar(isVisible = false)
                view?.showError(it.message)
            }, {
                view?.showProgressBar(isVisible = false)
                view?.displayData(it)
            })
        }
    }
}