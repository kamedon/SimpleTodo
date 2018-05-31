package com.kamedon.simpletodo.presenter.issue

import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.kamedon.simpletodo.R
import com.kamedon.simpletodo.databinding.ItemIssueBinding
import com.kamedon.simpletodo.domain.entity.Issue

class IssueListAdapter : RecyclerView.Adapter<IssueViewHolder>() {

    var issues: List<Issue> = listOf(Issue(body = "test"))

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IssueViewHolder {
        val view = View.inflate(parent.context, R.layout.item_issue, null)
        return IssueViewHolder(view)
    }

    override fun getItemCount(): Int = issues.size

    override fun onBindViewHolder(holder: IssueViewHolder, position: Int) {
        Log.d("issue", "onBindViewHolder: ${holder.binding?.root?.layoutParams?.javaClass?.simpleName}")

        holder.binding?.root?.also {
            it.layoutParams = RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT)
        }

        holder.bind(issues[position])

    }

}

class IssueViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val binding = DataBindingUtil.bind<ItemIssueBinding>(view)

    fun bind(issue: Issue) {
        binding ?: return
        binding.body.text = issue.body
    }
}