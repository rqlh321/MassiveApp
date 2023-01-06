package com.example.text_presentation_feature.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.text_presentation_feature.GroupedBannerItem

class GroupedDiffCallback : DiffUtil.ItemCallback<GroupedBannerItem>() {

    override fun areItemsTheSame(
        oldItem: GroupedBannerItem,
        newItem: GroupedBannerItem
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: GroupedBannerItem,
        newItem: GroupedBannerItem
    ) = oldItem == newItem
}