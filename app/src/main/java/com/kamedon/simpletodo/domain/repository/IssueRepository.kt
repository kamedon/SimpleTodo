package com.kamedon.simpletodo.domain.repository

import com.kamedon.simpletodo.domain.entity.Issue

interface IIssueRepository {
    suspend fun save(issue: Issue)
    suspend fun allIssue(): List<Issue>
}

class IssueRepository : IIssueRepository {
    val list = mutableListOf<Issue>()

    override suspend fun save(issue: Issue) {
        list.add(issue)
    }

    override suspend fun allIssue() = list
}
