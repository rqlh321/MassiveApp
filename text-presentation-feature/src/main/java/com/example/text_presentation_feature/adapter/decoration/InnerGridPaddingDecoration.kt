package com.example.text_presentation_feature.adapter.decoration

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.text_presentation_feature.R

class InnerGridPaddingDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val innerPadding = context.resources.getDimension(R.dimen.inner_padding).toInt()

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)

        val position = parent.getChildAdapterPosition(view)
        if (position % 2 == 0) {
            outRect.right = innerPadding
        }
        if (position < state.itemCount - 2) {
            outRect.bottom = innerPadding
        }
    }
}