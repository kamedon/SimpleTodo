package com.kamedon.simpletodo.presenter.issue

import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kamedon.simpletodo.R
import com.kamedon.simpletodo.databinding.FragmentIssueListBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class IssueListFragment : Fragment(), KodeinAware {
    private val parentKodein by closestKodein()
    lateinit var binding: FragmentIssueListBinding

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
    }

    private val presentViewModel: IssueListViewModel by instance()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_issue_list, container, false)
        binding.presentViewModel = presentViewModel
        binding.setLifecycleOwner(this)
        binding.nextBtn.setOnClickListener {
            binding.root.let { Navigation.findNavController(it).navigate(IssueListFragmentDirections.to_issue_form()) }
        }
        binding.issuesRecyclerView.adapter = IssueListAdapter()
        binding.issuesRecyclerView.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        binding.issuesRecyclerView.addItemDecoration(IssueDecoration())
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presentViewModel.issues.observe(this, Observer {
            val newIssues = it ?: emptyList()
            val adapter = binding.issuesRecyclerView.adapter as IssueListAdapter
            val diff = DiffUtil.calculateDiff(IssueDiffCallback(adapter.issues, newIssues), true)
            adapter.issues = newIssues
            diff.dispatchUpdatesTo(adapter)
            Log.d("issue", "update")
        })

    }

    override fun onStart() {
        super.onStart()
        presentViewModel.loadAll()
        Log.d("life", "onStart")
    }

    override fun onStop() {
        super.onStop()
        Log.d("life", "onStop")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("life", "onDestroy")
    }

}
