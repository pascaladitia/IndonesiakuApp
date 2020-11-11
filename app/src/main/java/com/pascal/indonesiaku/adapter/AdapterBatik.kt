package com.pascal.indonesiaku.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.pascal.indonesiaku.R
import com.pascal.indonesiaku.model.batik.HasilItem
import kotlinx.android.synthetic.main.item_batik.view.*

class AdapterBatik(
    val data: List<HasilItem?>?,
    val itemClick: OnClikListener
) : RecyclerView.Adapter<AdapterBatik.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterBatik.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_batik, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = data?.size ?: 0

    override fun onBindViewHolder(holder: AdapterBatik.ViewHolder, position: Int) {
        val item = data?.get(position)

        holder.nama.text = item?.namaBatik
        holder.deskripsi.text = item?.maknaBatik
        Glide.with(holder.itemView.context)
            .load(item?.linkBatik)
            .apply(RequestOptions()
                .override(500, 500)
                .placeholder(R.drawable.ic_image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .priority(Priority.HIGH))
            .into(holder.image)

        holder.itemView.setOnClickListener {
            itemClick.detail(item)
        }
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image = view.itemBatik_image
        val nama = view.itemBatik_title
        val deskripsi = view.itemBatik_deskripsi
    }

    interface OnClikListener {
        fun detail(item: HasilItem?)
    }
}