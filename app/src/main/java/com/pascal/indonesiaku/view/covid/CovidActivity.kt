package com.pascal.indonesiaku.view.covid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.adapter.AdapterCovid
import com.pascal.indonesiaku.model.covid.CovidItem
import com.pascal.indonesiaku.model.covid.ResponseCovid
import com.pascal.indonesiaku.viewModel.ViewModelConfig
import kotlinx.android.synthetic.main.activity_covid.*

class CovidActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid)

        initView()
        attachObserve()
    }

    private fun initView() {
        viewModel = ViewModelProviders.of(this).get(ViewModelConfig::class.java)
        viewModel.getCovidView()
    }

    private fun attachObserve() {
        viewModel.responseGetCovid.observe(this, Observer { showData(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
        viewModel.isError.observe(this, Observer { showError(it) })
    }

    private fun showData(it: ResponseCovid?) {
        val adapter = AdapterCovid(it?.data, object : AdapterCovid.OnClikListener {

            override fun detail(item: CovidItem?) {
                val intent = Intent(this@CovidActivity, CovidDetailActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }
        })
        recyclerview_covid.adapter = adapter
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            progress_covid.visibility = View.VISIBLE
        } else {
            progress_covid.visibility = View.GONE
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