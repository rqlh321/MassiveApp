package com.example.text_presentation_feature.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.text_presentation_feature.TextPresentationItem

class DiffCallback : DiffUtil.ItemCallback<TextPresentationItem>() {

    override fun areItemsTheSame(
        oldItem: TextPresentationItem,
        newItem: TextPresentationItem
    ) = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: TextPresentationItem,
        newItem: TextPresentationItem
    ) = oldItem == newItem
}