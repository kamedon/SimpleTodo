package com.kamedon.simpletodo.presenter.todo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.kamedon.simpletodo.R
import com.kamedon.simpletodo.databinding.FragmentTodoFormBinding
import com.kamedon.simpletodo.databinding.FragmentTodoListBinding

class TodoListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentTodoListBinding>(inflater, R.layout.fragment_todo_list, container, false)
        binding.nextBtn.setOnClickListener {
            view?.let { Navigation.findNavController(it).navigate(TodoListFragmentDirections.to_todo_form()) }
        }
        return binding.root
    }

}
