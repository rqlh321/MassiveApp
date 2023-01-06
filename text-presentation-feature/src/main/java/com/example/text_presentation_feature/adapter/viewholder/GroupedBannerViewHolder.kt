package com.example.text_presentation_feature.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.text_presentation_feature.GroupedBannerItem

abstract class GroupedBannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: GroupedBannerItem)
}