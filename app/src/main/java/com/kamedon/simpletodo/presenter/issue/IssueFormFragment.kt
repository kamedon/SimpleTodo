package com.kamedon.simpletodo.presenter.issue

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kamedon.simpletodo.R
import com.kamedon.simpletodo.databinding.FragmentIssueFormBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance


class IssueFormFragment : Fragment(), KodeinAware {
    private val parentKodein by closestKodein()

    override val kodein: Kodein = Kodein.lazy {
        extend(parentKodein)
    }

    private val presentViewModel: IssueFormViewModel by instance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentIssueFormBinding>(inflater, R.layout.fragment_issue_form, container, false)
        binding.presentViewModel = presentViewModel
        return binding.root
    }

}
