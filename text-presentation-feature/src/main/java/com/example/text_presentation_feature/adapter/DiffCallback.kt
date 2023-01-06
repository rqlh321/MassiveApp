package com.example.text_presentation_feature.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.text_presentation_feature.GroupItem

class DiffCallback : DiffUtil.ItemCallback<GroupItem>() {

    override fun areItemsTheSame(
        oldItem: GroupItem,
        newItem: GroupItem
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: GroupItem,
        newItem: GroupItem
    ) = oldItem == newItem
}