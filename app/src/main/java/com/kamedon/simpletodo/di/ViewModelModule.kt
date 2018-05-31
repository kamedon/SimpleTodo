package com.kamedon.simpletodo.di

import com.kamedon.simpletodo.presenter.issue.IssueFormViewModel
import com.kamedon.simpletodo.presenter.issue.IssueListViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider

object ViewModelModule {
    fun define() = Kodein.Module {
        bind<IssueFormViewModel>() with provider {
            IssueFormViewModel(instance())
        }
        bind<IssueListViewModel>() with provider {
            IssueListViewModel(instance())
        }
    }
}