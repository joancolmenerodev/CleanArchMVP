package com.joancolmenerodev.cleanarch.feature.coindetail.mvp

import com.joancolmenerodev.cleanarch.base.BasePresenter
import com.joancolmenerodev.cleanarch.base.PresenterView
import com.joancolmenerodev.features.coindetail.models.CoinDetail

interface CoinDetailContract {
    interface View : PresenterView {
        fun displayData(result: CoinDetail)
        fun showError(errorMessage: String?)
        fun showProgressBar(isVisible: Boolean)
    }

    interface Presenter : BasePresenter<View> {
        fun loadData(cryptoId: Int? = -1)
    }
}