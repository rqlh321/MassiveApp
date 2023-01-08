package com.example.text_presentation_feature.adapter.viewholder

import android.content.res.ColorStateList
import android.graphics.Color
import com.example.text_presentation_feature.GroupItem
import com.example.text_presentation_feature.databinding.BannerItemBigBinding

class BigBannerViewHolder(
    private val binding: BannerItemBigBinding,
) : BannerViewHolder(binding.root) {

    override fun bind(item: GroupItem) {
        try {
            binding.root.backgroundTintList = ColorStateList.valueOf(Color.parseColor(item.color))
        }catch (e:Exception){
            println(item.color)
            e.printStackTrace()
        }
        binding.title.text = item.text
    }
}