package com.pascal.indonesiaku.view.covid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.model.covid.CovidItem
import kotlinx.android.synthetic.main.activity_covid_detail.*

class CovidDetailActivity : AppCompatActivity() {

    private var item: CovidItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_detail)

        initView()
    }

    private fun initView() {
        item = intent?.getParcelableExtra("data")

        detailCovid_nama.setText(item?.provinsi)
        detailCovid_positif.setText("${item?.kasusPosi}")
        detailCovid_sembuh.setText("${item?.kasusSemb}")
        detailCovid_meninggal.setText("${item?.kasusMeni}")

        detailCovid_close.setOnClickListener {
            onBackPressed()
            finish()
        }
    }
}