package com.pascal.indonesiaku.view.batik

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.adapter.AdapterBatik
import com.pascal.indonesiaku.model.batik.HasilItem
import com.pascal.indonesiaku.model.batik.ResponseBatik
import com.pascal.indonesiaku.viewModel.ViewModelConfig
import kotlinx.android.synthetic.main.activity_batik.*

class BatikActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_batik)

        initView()
        attachObserve()
    }

    private fun initView() {
        viewModel = ViewModelProviders.of(this).get(ViewModelConfig::class.java)
        viewModel.getBatikView()
    }

    private fun attachObserve() {
        viewModel.responseGetBatik.observe(this, Observer { showData(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
        viewModel.isError.observe(this, Observer { showError(it) })
    }

    private fun showData(it: ResponseBatik?) {
        val adapter = AdapterBatik(it?.hasil, object : AdapterBatik.OnClikListener {

            override fun detail(item: HasilItem?) {
                val intent = Intent(this@BatikActivity, BatikDetailActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }
        })
        recyclerview_main.adapter = adapter
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            progress_main.visibility = View.VISIBLE
        } else {
            progress_main.visibility = View.GONE
        }
    }

    private fun showError(it: Throwable?) {
        showToast(it.toString())
    }

    private fun showToast(msg: String) {
        Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        attachObserve()
    }
}