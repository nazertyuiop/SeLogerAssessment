package com.assessment.seloger.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assessment.domain.model.Announce
import com.assessment.seloger.R
import com.assessment.seloger.utils.setImageUrl
import kotlinx.android.synthetic.main.fragment_detail_announce.*


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
        val tvGeneralInfo: TextView = itemView.findViewById(R.id.tvGeneralInfo)
    }

    private fun bind(holder: AnnounceViewHolder, item: Announce) = with(holder) {
        img.setImageUrl(item.image)
        tvGeneralInfo.text = "${item.city} . ${item.price} . ${item.area} m "

        itemView.setOnClickListener { itemClickListener?.invoke(item) }
    }
}