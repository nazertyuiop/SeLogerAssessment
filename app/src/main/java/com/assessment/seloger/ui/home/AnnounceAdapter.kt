package com.assessment.seloger.ui.home

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.assessment.domain.model.Announce
import com.assessment.domain.model.getGeneralInfo
import com.assessment.seloger.R
import com.assessment.seloger.databinding.AnnonceListItemBinding
import com.assessment.seloger.utils.livedata.inflate
import com.assessment.seloger.utils.setImageUrl


class AnnounceAdapter : RecyclerView.Adapter<AnnounceAdapter.AnnounceViewHolder>() {

    var items = listOf<Announce>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    var itemClickListener: ((Announce) -> Unit)? = null

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnnounceViewHolder =
        AnnounceViewHolder(parent.inflate(R.layout.annonce_list_item))

    override fun onBindViewHolder(holder: AnnounceViewHolder, position: Int) {
        val announce: Announce = items[position]
        holder.bind(announce)
    }

    inner class AnnounceViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = AnnonceListItemBinding.bind(itemView)

        fun bind(item: Announce) = with(item) {
            binding.image.setImageUrl(image)
            binding.tvGeneralInfo.text = getGeneralInfo()

            itemView.setOnClickListener { itemClickListener?.invoke(item) }
        }
    }
}