package com.example.text_presentation_feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.android_core.click
import com.example.text_presentation_feature.GroupedBannerItem
import com.example.text_presentation_feature.adapter.viewholder.GroupedBannerViewHolder
import com.example.text_presentation_feature.adapter.viewholder.MediumBannerViewHolder
import com.example.text_presentation_feature.databinding.BannerItemMediumBinding

class BannerGroupGridAdapter(
    private val onBannerClick: (String) -> Unit
) : ListAdapter<GroupedBannerItem, GroupedBannerViewHolder>(GroupedDiffCallback()) {


    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int) = getItem(position).id.hashCode().toLong()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MediumBannerViewHolder(
        BannerItemMediumBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    ).apply { itemView.click { onBannerClick.invoke(getItem(absoluteAdapterPosition).id) } }

    override fun onBindViewHolder(
        holder: GroupedBannerViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

}
