package com.kamedon.simpletodo.di

import com.kamedon.simpletodo.presenter.todo.IssueListPresentViewModel
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.provider

object PresentViewModelModule {
    fun define() = Kodein.Module {
        bind<IssueListPresentViewModel>() with provider {
            IssueListPresentViewModel()
        }
    }
}