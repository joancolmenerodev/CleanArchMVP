package com.joancolmenerodev.cleanarch.feature.coinlist.mvp

import com.joancolmenerodev.ResultWrapper
import com.joancolmenerodev.cleanarch.base.threading.TestDispatcherProvider
import com.joancolmenerodev.cleanarch.feature.coinlist.usecase.GetCoinListUseCase
import com.joancolmenerodev.features.coinlist.models.CoinList
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class CoinListPresenterTest {


    private var view: CoinListContract.View = mock()

    private var getCryptoListUseCase: GetCoinListUseCase = mock()

    private lateinit var presenter: CoinListPresenter


    @Before
    fun setUp() {
        presenter = CoinListPresenter(getCryptoListUseCase, TestDispatcherProvider())
    }

    @Test
    fun `Given an user opens the page it autommatically loads a list of quest`() {

        //Assign
        presenter.onViewReady(view)
        runBlocking {
            whenever(getCryptoListUseCase.execute()).thenReturn(ResultWrapper.Success(coinList))
        }

        //Act
        presenter.loadResults()

        //Assert
        verify(view).showProgressBar(true)
        verify(view).showResults(coinList)
    }

    @Test
    fun `Given an user tries to load the data and it fails THEN it shows an error`() {
        //Assign
        presenter.onViewReady(view)
        val errorMessage = "Something went wrong"
        runBlocking {
            whenever(getCryptoListUseCase.execute()).thenReturn(
                ResultWrapper.Failure(
                    Throwable(
                        errorMessage
                    )
                )
            )
        }

        //Act
        presenter.loadResults()

        //Assert
        verify(view).showProgressBar(true)
        verify(view).showError(errorMessage)

    }

    companion object {
        private val coinList = arrayListOf(
            CoinList(1, "Bitcoin", "BTC"),
            CoinList(2, "Potcoin", "POT")
        )
    }


}