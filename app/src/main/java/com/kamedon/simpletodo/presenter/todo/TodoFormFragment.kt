package com.kamedon.simpletodo.presenter.todo

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kamedon.simpletodo.R
import com.kamedon.simpletodo.databinding.FragmentTodoFormBinding
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein


class TodoFormFragment : Fragment(), KodeinAware {
    override val kodein: Kodein by closestKodein()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTodoFormBinding>(inflater, R.layout.fragment_todo_form, container, false)
        return binding.root
    }

}
