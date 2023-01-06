package com.example.text_presentation_feature.adapter.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.text_presentation_feature.R
import com.example.text_presentation_feature.adapter.viewholder.GroupListBannerViewHolder

class PaddingDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val innerPadding = context.resources.getDimension(R.dimen.inner_padding).toInt()
    private val outerPadding = context.resources.getDimension(R.dimen.outer_padding).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        if (parent.getChildViewHolder(view) !is GroupListBannerViewHolder) {
            outRect.left = outerPadding
            outRect.right = outerPadding
        }

        when (parent.getChildAdapterPosition(view)) {
            state.itemCount - 1 -> { outRect.top = innerPadding }
            else                -> { outRect.bottom = innerPadding }
        }

    }
}