package com.example.text_presentation_feature.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.banner_api.Banner.Companion.PRESENTATION_GRID
import com.example.banner_api.Banner.Companion.PRESENTATION_LIST
import com.example.banner_api.Banner.Companion.PRESENTATION_SINGLE
import com.example.text_presentation_feature.GroupItem
import com.example.text_presentation_feature.adapter.viewholder.BannerViewHolder
import com.example.text_presentation_feature.adapter.viewholder.BigBannerViewHolder
import com.example.text_presentation_feature.adapter.viewholder.GroupGridBannerViewHolder
import com.example.text_presentation_feature.adapter.viewholder.GroupListBannerViewHolder
import com.example.text_presentation_feature.databinding.BannerGroupGridItemBinding
import com.example.text_presentation_feature.databinding.BannerGroupListHorizontalItemBinding
import com.example.text_presentation_feature.databinding.BannerItemBigBinding

class BannerAdapter : ListAdapter<GroupItem, BannerViewHolder>(DiffCallback()) {

    override fun getItemViewType(position: Int) = getItem(position).presentation

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        PRESENTATION_SINGLE -> BigBannerViewHolder(
            BannerItemBigBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        PRESENTATION_LIST -> GroupListBannerViewHolder(
            BannerGroupListHorizontalItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
        PRESENTATION_GRID -> GroupGridBannerViewHolder(
            BannerGroupGridItemBinding.inflate(
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
