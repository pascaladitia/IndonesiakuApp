package com.pascal.indonesiaku.view.museum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.model.museum.MuseumItem
import kotlinx.android.synthetic.main.activity_museum_detail.*

class MuseumDetailActivity : AppCompatActivity() {

    private var item: MuseumItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum_detail)

        initView()
    }

    private fun initView() {
        item = intent?.getParcelableExtra("data")

        detailMuseum_nama.setText(item?.nama)
        detailMuseum_alamat.setText(item?.alamatJalan)
        detailMuseum_kota.setText(item?.kabupatenKota)
        detailMuseum_provinsi.setText(item?.propinsi)
        detailMuseum_pengelola.setText(item?.pengelola)

        detailMuseum_close.setOnClickListener {
            onBackPressed()
            finish()
        }
    }
}