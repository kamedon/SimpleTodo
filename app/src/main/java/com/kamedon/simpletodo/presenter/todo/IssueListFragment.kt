package com.kamedon.simpletodo.presenter.todo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.kamedon.simpletodo.R
import com.kamedon.simpletodo.databinding.FragmentIssueListBinding

class IssueListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentIssueListBinding>(inflater, R.layout.fragment_issue_list, container, false)
        binding.nextBtn.setOnClickListener {
            view?.let { Navigation.findNavController(it).navigate(IssueListFragmentDirections.to_issue_form()) }
        }
        return binding.root
    }

}
