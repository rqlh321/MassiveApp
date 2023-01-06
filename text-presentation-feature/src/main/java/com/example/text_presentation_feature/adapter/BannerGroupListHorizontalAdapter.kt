package com.example.text_presentation_feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.text_presentation_feature.GroupedBannerItem
import com.example.text_presentation_feature.adapter.viewholder.GroupedBannerViewHolder
import com.example.text_presentation_feature.adapter.viewholder.SmallBannerViewHolder
import com.example.text_presentation_feature.databinding.BannerItemSmallBinding

class BannerGroupListHorizontalAdapter : ListAdapter<GroupedBannerItem, GroupedBannerViewHolder>(GroupedDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SmallBannerViewHolder(
        BannerItemSmallBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: GroupedBannerViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

}
