package com.assessment.seloger.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.assessment.domain.model.Announce
import com.assessment.seloger.R
import com.assessment.seloger.utils.setImageUrl


class AnnounceAdapter() : RecyclerView.Adapter<AnnounceAdapter.AnnounceViewHolder>() {

    var items = mutableListOf<Announce>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var itemClickListener: ((Announce) -> Unit)? = null

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnounceViewHolder =
        AnnounceViewHolder(
            (LayoutInflater.from(parent.context).inflate(R.layout.annonce_list_item, parent, false))
        )

    override fun onBindViewHolder(holder: AnnounceViewHolder, position: Int) {
        val gifObj: Announce = items[position]
        bind(holder, gifObj)
    }

    inner class AnnounceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val img: ImageView = itemView.findViewById(R.id.image)
    }

    private fun bind(holder: AnnounceViewHolder, item: Announce) = with(holder) {
        img.setImageUrl(item.image)
        itemView.setOnClickListener { itemClickListener?.invoke(item) }
    }
}