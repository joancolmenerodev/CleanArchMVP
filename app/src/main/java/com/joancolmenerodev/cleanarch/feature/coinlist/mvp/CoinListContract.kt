package com.joancolmenerodev.cleanarch.feature.coinlist.mvp

import com.joancolmenerodev.cleanarch.base.BasePresenter
import com.joancolmenerodev.cleanarch.base.PresenterView
import com.joancolmenerodev.features.coinlist.models.CoinList

interface CoinListContract {
    interface View : PresenterView {
        fun showResults(currencyList: List<CoinList>)
        fun showError(errorMessage: String?)
        fun showProgressBar(isVisible: Boolean)
        fun navigateToCoinDetail(cryptoId: Int)
    }

    interface Presenter : BasePresenter<View> {
        fun loadResults()
        fun onCoinClicked(cryptoId: Int)
    }
}