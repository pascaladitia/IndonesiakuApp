package com.pascal.indonesiaku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.model.museum.MuseumItem
import kotlinx.android.synthetic.main.item_museum.view.*

class AdapterMuseum(
    val data: List<MuseumItem?>?,
    val itemClick: OnClikListener
) : RecyclerView.Adapter<AdapterMuseum.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterMuseum.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_museum, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: AdapterMuseum.ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.nama.text = item?.nama
        holder.lokasi.text = "Lokasi : ${item?.kabupatenKota}"

        holder.itemView.setOnClickListener {
            itemClick.detail(item)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.itemMuseum_nama
        val lokasi = view.itemMuseum_lokasi
    }

    interface OnClikListener {
        fun detail(item: MuseumItem?)
    }
}