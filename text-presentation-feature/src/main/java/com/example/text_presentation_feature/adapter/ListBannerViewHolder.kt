package com.example.text_presentation_feature.adapter

import com.example.text_presentation_feature.TextPresentationItem
import com.example.text_presentation_feature.databinding.BannerListHorizontalItemBinding

class ListBannerViewHolder(
    private val binding: BannerListHorizontalItemBinding
) : BannerViewHolder(binding.root) {
    private val adapter = InnerBannerListAdapter()

    init {
        binding.list.adapter = adapter
        binding.list.addItemDecoration(InnerPaddingDecoration(itemView.context))
    }

    override fun bind(item: TextPresentationItem) {
        adapter.submitList(item.list)
    }
}