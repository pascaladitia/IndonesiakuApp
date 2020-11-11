package com.pascal.indonesiaku.view.daerah

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.adapter.AdapterDaerah
import com.pascal.indonesiaku.model.daerah.DataItem
import com.pascal.indonesiaku.model.daerah.ResponseDaerah
import com.pascal.indonesiaku.viewModel.ViewModelConfig
import kotlinx.android.synthetic.main.activity_daerah.*
import kotlinx.android.synthetic.main.dialog_daerah.*

class DaerahActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_daerah)

        initView()
        attachObserve()
    }

    private fun initView() {
        viewModel = ViewModelProviders.of(this).get(ViewModelConfig::class.java)
        viewModel.getDaerahView()
    }

    private fun attachObserve() {
        viewModel.responseGetDaerah.observe(this, Observer { showData(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
        viewModel.isError.observe(this, Observer { showError(it) })
    }

    private fun showData(it: ResponseDaerah?) {
        val adapter = AdapterDaerah(it?.data, object : AdapterDaerah.OnClikListener {

            override fun detail(item: DataItem?) {
                showDialog(item!!)
            }
        })
        recyclerview_daerah.adapter = adapter
    }

    private fun showDialog(item: DataItem) {
        Dialog(this).apply {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setCancelable(true)
            setContentView(R.layout.dialog_daerah)

            dialogDaerah_id.text = "Id Provinsi : ${item.id}"
            dialogDaerah_nama.text = "Nama : ${item.name}"

            dialogDaerah_close.setOnClickListener {
                this.dismiss()
            }
        }.show()
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            progress_daerah.visibility = View.VISIBLE
        } else {
            progress_daerah.visibility = View.GONE
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