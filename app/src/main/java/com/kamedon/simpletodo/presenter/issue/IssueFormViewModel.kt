package com.kamedon.simpletodo.presenter.issue

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.kamedon.simpletodo.domain.entity.Issue
import com.kamedon.simpletodo.domain.repository.IIssueRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.Unconfined
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.coroutineContext

class IssueFormViewModel(val issueRepository: IIssueRepository) : ViewModel() {

    val body = MutableLiveData<String>()

    fun save() {
        launch(UI) {
            async(coroutineContext + CommonPool) {
                issueRepository.save(Issue(body = body.value ?: ""))
            }.await()
            body.value = "ok"
        }
    }

}
