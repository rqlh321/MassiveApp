package com.example.text_presentation_feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.text_presentation_feature.TextPresentationItem
import com.example.text_presentation_feature.databinding.BannerListHorizontalItemBinding
import com.example.text_presentation_feature.databinding.BigBannerItemBinding

class BannerListAdapter : ListAdapter<TextPresentationItem, BannerViewHolder>(DiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        return if(getItem(position).list.isEmpty()) 0 else 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        0 -> BigBannerViewHolder(
            BigBannerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        1 -> ListBannerViewHolder(
            BannerListHorizontalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        else -> throw IllegalArgumentException()
    }

    override fun onBindViewHolder(
        holder: BannerViewHolder,
        position: Int
    ) = holder.bind(getItem(position))

}
