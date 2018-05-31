package com.kamedon.simpletodo.presenter.issue

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.kamedon.simpletodo.domain.entity.Issue
import com.kamedon.simpletodo.domain.repository.IIssueRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

class IssueListViewModel(val issueRepository: IIssueRepository) {
    val issues = MutableLiveData<List<Issue>>()

    fun loadAll() {
        launch(UI) {
            val data = async(CommonPool) {
                issueRepository.allIssue()
            }.await()
            issues.value = data
            Log.d("issue", data.toString())
        }
    }
}