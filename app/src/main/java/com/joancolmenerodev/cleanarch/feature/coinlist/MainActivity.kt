package com.joancolmenerodev.cleanarch.feature.coinlist

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import com.joancolmenerodev.cleanarch.R
import com.joancolmenerodev.cleanarch.extensions.view.setVisibile
import com.joancolmenerodev.cleanarch.feature.coindetail.CoinDetailActivity
import com.joancolmenerodev.cleanarch.feature.coinlist.mvp.CoinListContract
import com.joancolmenerodev.cleanarch.feature.coinlist.ui.CoinListAdapter
import com.joancolmenerodev.features.coinlist.models.CoinList
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware, CoinListContract.View {

    override val kodein by kodein()

    private lateinit var adapter: CoinListAdapter
    private lateinit var gridLayoutManager: GridLayoutManager

    private val presenter : CoinListContract.Presenter by instance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onViewReady(this)
        initViews()
        presenter.loadResults()
    }

    override fun onResume() {
        super.onResume()
        presenter.onViewReady(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.onViewDestroyed()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onViewDestroyed()
    }

    private fun initViews() {
        gridLayoutManager = GridLayoutManager(this, 2)
    }

    override fun showResults(currencyList: List<CoinList>) {
        adapter = CoinListAdapter(currencyList)
        rv_crypto_currency_list.adapter = adapter
        rv_crypto_currency_list.layoutManager = gridLayoutManager
        adapter.let {
            it.onItemClick = { cryptoId -> presenter.onCoinClicked(cryptoId) }
        }
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(this,errorMessage,Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar(isVisible: Boolean) {
        progressbar_list.setVisibile(isVisible)
    }

    override fun navigateToCoinDetail(cryptoId: Int) {
        startActivity(CoinDetailActivity.getCoinDetailIntent(this,cryptoId = cryptoId))
    }

}
