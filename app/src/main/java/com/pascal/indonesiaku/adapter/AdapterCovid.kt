package com.pascal.indonesiaku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.model.covid.CovidItem
import kotlinx.android.synthetic.main.item_covid.view.*

class AdapterCovid(
    val data: List<CovidItem?>?,
    val itemClick: OnClikListener
) : RecyclerView.Adapter<AdapterCovid.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterCovid.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: AdapterCovid.ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.nama.text = item?.provinsi
        holder.positif.text = "Kasus Positif : ${item?.kasusPosi}"

        holder.itemView.setOnClickListener {
            itemClick.detail(item)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.itemCovid_nama
        val positif = view.itemCovid_positif
    }

    interface OnClikListener {
        fun detail(item: CovidItem?)
    }
}