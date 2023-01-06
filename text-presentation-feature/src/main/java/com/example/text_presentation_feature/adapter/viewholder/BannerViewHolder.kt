package com.example.text_presentation_feature.adapter.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.text_presentation_feature.GroupItem

abstract class BannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: GroupItem)
}