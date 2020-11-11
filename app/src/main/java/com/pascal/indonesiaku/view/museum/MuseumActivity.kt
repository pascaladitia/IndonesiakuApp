package com.pascal.indonesiaku.view.museum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.adapter.AdapterMuseum
import com.pascal.indonesiaku.model.museum.MuseumItem
import com.pascal.indonesiaku.model.museum.ResponseMuseum
import com.pascal.indonesiaku.viewModel.ViewModelConfig
import kotlinx.android.synthetic.main.activity_museum.*

class MuseumActivity : AppCompatActivity() {

    private lateinit var viewModel: ViewModelConfig

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        initSearch()
        initView()
        attachObserve()
    }

    private fun initSearch() {
        museum_search.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                viewModel.getMuseumByNameView(query)
                return false
            }
            override fun onQueryTextChange(newText: String): Boolean {
                viewModel.getMuseumByNameView(newText)
                return false
            }
        })
    }

    private fun initView() {
        viewModel = ViewModelProviders.of(this).get(ViewModelConfig::class.java)
        viewModel.getMuseumView()
    }

    private fun attachObserve() {
        viewModel.responseGetMuseum.observe(this, Observer { showData(it) })
        viewModel.isLoading.observe(this, Observer { showLoading(it) })
        viewModel.isError.observe(this, Observer { showError(it) })
    }

    private fun showData(it: ResponseMuseum?) {
        val adapter = AdapterMuseum(it?.data, object : AdapterMuseum.OnClikListener {

            override fun detail(item: MuseumItem?) {
                val intent = Intent(this@MuseumActivity, MuseumDetailActivity::class.java)
                intent.putExtra("data", item)
                startActivity(intent)
            }
        })
        recyclerview_museum.adapter = adapter
    }

    private fun showLoading(it: Boolean?) {
        if (it == true) {
            progress_museum.visibility = View.VISIBLE
        } else {
            progress_museum.visibility = View.GONE
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