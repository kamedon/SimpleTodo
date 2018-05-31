package com.kamedon.simpletodo.presenter.issue

import android.databinding.BindingAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import com.kamedon.simpletodo.domain.entity.Issue

class IssueDiffCallback(val oldIssues: List<Issue>, val newIssues: List<Issue>) : DiffUtil.Callback() {
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldIssues[oldItemPosition].id == newIssues[newItemPosition].id
    }

    override fun getOldListSize(): Int = oldIssues.size

    override fun getNewListSize(): Int = newIssues.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldIssues[oldItemPosition] == newIssues[newItemPosition]
    }

}

