package com.pascal.indonesiaku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.model.daerah.DataItem
import kotlinx.android.synthetic.main.item_daerah.view.*

class AdapterDaerah(
    val data: List<DataItem?>?,
    val itemClick: OnClikListener
) : RecyclerView.Adapter<AdapterDaerah.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterDaerah.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_daerah, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: AdapterDaerah.ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.nama.text = item?.name
        holder.id.text = "id provinsi : ${item?.id}"

        holder.itemView.setOnClickListener {
            itemClick.detail(item)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nama = view.itemDaerah_nama
        val id = view.itemDaerah_id
    }

    interface OnClikListener {
        fun detail(item: DataItem?)
    }
}