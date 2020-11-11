package com.pascal.indonesiaku.view.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.view.batik.BatikActivity
import com.pascal.indonesiaku.view.covid.CovidActivity
import com.pascal.indonesiaku.view.daerah.DaerahActivity
import com.pascal.indonesiaku.view.museum.MuseumActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_daerah.setOnClickListener(this)
        main_batik.setOnClickListener(this)
        main_museum.setOnClickListener(this)
        main_covid.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.main_daerah -> {
                startActivity(Intent(this, DaerahActivity::class.java))
            }

            R.id.main_batik -> {
                startActivity(Intent(this, BatikActivity::class.java))
            }

            R.id.main_museum -> {
                startActivity(Intent(this, MuseumActivity::class.java))
            }

            R.id.main_covid -> {
                startActivity(Intent(this, CovidActivity::class.java))
            }
        }
    }
}