package com.example.text_presentation_feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.text_presentation_feature.TextPresentationItem
import com.example.text_presentation_feature.databinding.SmallBannerItemBinding

class InnerBannerListAdapter : ListAdapter<TextPresentationItem, BannerViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = SmallBannerViewHolder(
        SmallBannerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    )

    override fun onBindViewHolder(
        holder: BannerViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

}
