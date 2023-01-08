package com.example.text_presentation_feature.adapter.viewholder

import android.content.res.ColorStateList
import android.graphics.Color
import com.example.text_presentation_feature.GroupedBannerItem
import com.example.text_presentation_feature.databinding.BannerItemSmallBinding

class SmallBannerViewHolder(
    private val binding: BannerItemSmallBinding
) : GroupedBannerViewHolder(binding.root) {

    override fun bind(item: GroupedBannerItem) {
        try {
            binding.root.backgroundTintList = ColorStateList.valueOf(Color.parseColor(item.color))
        }catch (e:Exception){
            println(item.color)
            e.printStackTrace()
        }
        binding.title.text = item.text
    }
}