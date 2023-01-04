package com.example.text_presentation_feature.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.text_presentation_feature.TextPresentationItem

abstract class BannerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    abstract fun bind(item: TextPresentationItem)
}