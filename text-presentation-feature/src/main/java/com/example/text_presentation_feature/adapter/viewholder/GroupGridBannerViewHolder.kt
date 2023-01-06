package com.example.text_presentation_feature.adapter.viewholder

import androidx.recyclerview.widget.GridLayoutManager
import com.example.text_presentation_feature.GroupItem
import com.example.text_presentation_feature.adapter.BannerGroupGridAdapter
import com.example.text_presentation_feature.adapter.decoration.InnerGridPaddingDecoration
import com.example.text_presentation_feature.databinding.BannerGroupGridItemBinding

class GroupGridBannerViewHolder(
    binding: BannerGroupGridItemBinding
) : BannerViewHolder(binding.root) {

    private val adapter = BannerGroupGridAdapter()

    init {
        (binding.list.layoutManager as GridLayoutManager).apply {
            this.spanCount = 2
        }
        binding.list.adapter = adapter
        binding.list.addItemDecoration(InnerGridPaddingDecoration(itemView.context))
    }

    override fun bind(item: GroupItem) {
        adapter.submitList(item.list)
    }
}