package com.kamedon.simpletodo.di

import com.kamedon.simpletodo.domain.repository.IIssueRepository
import com.kamedon.simpletodo.domain.repository.IssueRepository
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton


object RepositoryModule {
    fun define() = Kodein.Module {
        bind<IIssueRepository>() with singleton {
            IssueRepository()
        }
    }
}