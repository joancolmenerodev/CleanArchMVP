package com.joancolmenerodev.cleanarch.feature.coindetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.joancolmenerodev.cleanarch.R
import com.joancolmenerodev.cleanarch.extensions.view.loadImage
import com.joancolmenerodev.cleanarch.extensions.view.setVisibile
import com.joancolmenerodev.cleanarch.feature.coindetail.mvp.CoinDetailContract
import com.joancolmenerodev.features.coindetail.models.CoinDetail
import kotlinx.android.synthetic.main.activity_coin_detail.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class CoinDetailActivity : AppCompatActivity(), KodeinAware, CoinDetailContract.View {

    override val kodein by kodein()

    private val presenter: CoinDetailContract.Presenter by instance()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
        presenter.onViewReady(this)
        presenter.loadData(getIntentInfo())
    }

    override fun displayData(result: CoinDetail) {
        tv_cryptoName.text = result.name
        tv_cryptoSymbol.text = result.symbol
        tv_cryptoDescription.text = result.description
        tv_cryptoWebsite.text = result.website
        iv_crypto_logo.loadImage(result.logo,android.R.drawable.stat_notify_error)
    }

    override fun showError(errorMessage: String) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun showProgressBar(isVisible: Boolean) {
        progressbar_detail.setVisibile(isVisible)
    }

    private fun getIntentInfo() = intent?.extras?.getInt(COIN_ID, -1)

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

    companion object {
        private const val COIN_ID = "COIN_ID"

        @JvmStatic
        fun getCoinDetailIntent(context: Context, cryptoId: Int) =
            Intent(context, CoinDetailActivity::class.java).apply {
                putExtra(
                    COIN_ID, cryptoId
                )
            }
    }
}
