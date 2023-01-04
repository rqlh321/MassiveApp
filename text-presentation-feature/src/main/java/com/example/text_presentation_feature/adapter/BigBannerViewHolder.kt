package com.example.text_presentation_feature.adapter

import android.graphics.Color
import com.example.text_presentation_feature.TextPresentationItem
import com.example.text_presentation_feature.databinding.BigBannerItemBinding

class BigBannerViewHolder(
    private val binding: BigBannerItemBinding
) : BannerViewHolder(binding.root) {

    override fun bind(item: TextPresentationItem) {
        binding.root.setBackgroundColor(Color.parseColor(item.color))
        binding.title.text = item.text
    }
}