package com.example.text_presentation_feature.adapter.viewholder

import com.example.text_presentation_feature.GroupItem
import com.example.text_presentation_feature.adapter.BannerGroupListHorizontalAdapter
import com.example.text_presentation_feature.adapter.decoration.InnerListPaddingDecoration
import com.example.text_presentation_feature.databinding.BannerGroupListHorizontalItemBinding

class GroupListBannerViewHolder(
    binding: BannerGroupListHorizontalItemBinding,
    onBannerClick: (String) -> Unit
) : BannerViewHolder(binding.root) {

    private val adapter = BannerGroupListHorizontalAdapter(onBannerClick)

    init {
        binding.list.setHasFixedSize(true)
        binding.list.adapter = adapter
        binding.list.addItemDecoration(InnerListPaddingDecoration(itemView.context))
    }

    override fun bind(item: GroupItem) {
        adapter.submitList(item.list)
    }
}