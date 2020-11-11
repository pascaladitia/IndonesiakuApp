package com.pascal.indonesiaku.view.batik

import android.graphics.text.LineBreaker.JUSTIFICATION_MODE_INTER_WORD
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.model.batik.HasilItem
import kotlinx.android.synthetic.main.activity_batik_detail.*

class BatikDetailActivity : AppCompatActivity() {

    private var item: HasilItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik_detail)

        initView()
    }

    private fun initView() {
        item = intent?.getParcelableExtra("data")

        detailBatik_hitung.setText("Harga : Rp.${item?.hargaTinggi}")
        detailBatik_nama.setText(item?.namaBatik)
        detailBatik_deskripsi.setText(item?.maknaBatik)
        detailBatik_hargaTinggi.setText("Rp.${item?.hargaTinggi}")
        detailBatik_hargaRendah.setText("Rp.${item?.hargaRendah}")
        detailBatik_daerah.setText(item?.daerahBatik)

        Glide.with(this)
            .load(item?.linkBatik)
            .apply(
                RequestOptions()
                .override(500, 500)
                .placeholder(R.drawable.ic_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH))
            .into(detailBatik_image)

        detailBatik_close.setOnClickListener {
            onBackPressed()
            finish()
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            detailBatik_deskripsi.justificationMode = JUSTIFICATION_MODE_INTER_WORD
        }
    }
}