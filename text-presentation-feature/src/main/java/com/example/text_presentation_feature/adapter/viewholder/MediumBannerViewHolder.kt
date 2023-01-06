package com.example.text_presentation_feature.adapter.viewholder

import android.content.res.ColorStateList
import android.graphics.Color
import com.example.text_presentation_feature.GroupedBannerItem
import com.example.text_presentation_feature.databinding.BannerItemMediumBinding

class MediumBannerViewHolder(
    private val binding: BannerItemMediumBinding
) : GroupedBannerViewHolder(binding.root) {

    override fun bind(item: GroupedBannerItem) {
        binding.root.backgroundTintList = ColorStateList.valueOf(Color.parseColor(item.color))
        binding.title.text = item.text
    }
}