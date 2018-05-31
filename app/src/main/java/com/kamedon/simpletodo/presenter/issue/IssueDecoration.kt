package com.kamedon.simpletodo.presenter.issue

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View
import com.kamedon.simpletodo.utils.extensions.dp

class IssueDecoration : RecyclerView.ItemDecoration() {
    val top = 10.dp
    val bottom = 10.dp
    val left = 10.dp
    val right = 10.dp

    val topHalf = top / 2
    val bottomHalf = bottom / 2

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val position = parent.getChildAdapterPosition(view)
        if (position == 0) {
            outRect.top = top
        } else {
            outRect.top = topHalf
        }

        if (position == parent.adapter.itemCount - 1) {
            outRect.bottom = bottom
        } else {
            outRect.bottom = bottomHalf
        }

        outRect.left = left
        outRect.right = right

    }


}
