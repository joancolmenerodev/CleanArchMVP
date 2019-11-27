package com.joancolmenerodev.cleanarch.feature.coindetail

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.cleanarch.base.threading.TestDispatcherProvider
import com.joancolmenerodev.cleanarch.feature.coindetail.mvp.CoinDetailContract
import com.joancolmenerodev.cleanarch.feature.coindetail.mvp.CoinDetailPresenter
import com.joancolmenerodev.features.coindetail.models.CoinDetail
import com.joancolmenerodev.features.coindetail.usecase.GetCoinDetailUseCase
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CoinDetailPresenterTest {

    private var view: CoinDetailContract.View = mock()

    private var getCoinDetailUseCase: GetCoinDetailUseCase = mock()

    private lateinit var presenter: CoinDetailPresenter

    @Before
    fun setUp(){
        presenter = CoinDetailPresenter(getCoinDetailUseCase, TestDispatcherProvider())
    }

    @Test
    fun `Given an user taps on an item of the list then it opens the detail page and show its content`(){
        //Assign
        presenter.onViewReady(view)
        runBlocking {
            whenever(getCoinDetailUseCase.execute(COIN_ID)).thenReturn(ResultWrapper.Success(
                coinDetail))
        }

        //Act
        presenter.loadData(COIN_ID)

        //Assert
        verify(view).showProgressBar(true)
        verify(view).displayData(coinDetail)

    }

    @Test
    fun `Given an user taps on an item of the list and it fails then it shows an error`(){
        //Assign
        presenter.onViewReady(view)
        val errorMessage = "Something went wrong"
        runBlocking {
            whenever(getCoinDetailUseCase.execute(COIN_ID)).thenReturn(ResultWrapper.Failure(Throwable(errorMessage)))
        }

        //Act
        presenter.loadData(COIN_ID)

        //Assert
        verify(view).showProgressBar(true)
        verify(view).showError(errorMessage)

    }

    companion object {
        private const val COIN_ID = 1
        private val coinDetail = CoinDetail(
            logo = "http://logo.png",
            name = "Bitcoin",
            symbol = "BTC",
            description = "This is a description of Bitcoin",
            website = "www.bitcoin.io"
        )
    }
}