package com.joancolmenerodev.cleanarch.feature.coindetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.joancolmenerodev.cleanarch.R

class CoinDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coin_detail)
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
