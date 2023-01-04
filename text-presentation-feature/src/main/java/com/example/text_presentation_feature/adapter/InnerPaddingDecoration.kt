package com.example.text_presentation_feature.adapter

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.text_presentation_feature.R

class InnerPaddingDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val innerPadding = context.resources.getDimension(R.dimen.inner_padding).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        if (parent.getChildAdapterPosition(view) != state.itemCount - 1) {
            outRect.right = innerPadding
        }
    }
}