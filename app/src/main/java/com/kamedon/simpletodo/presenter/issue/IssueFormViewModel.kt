package com.kamedon.simpletodo.presenter.issue

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.kamedon.simpletodo.domain.repository.IIssueRepository

class IssueFormViewModel(val issueRepository: IIssueRepository) : ViewModel() {

    val body = MutableLiveData<String>()

    fun save() {
        Log.d("test", "test: ${body.value}")
    }

}
