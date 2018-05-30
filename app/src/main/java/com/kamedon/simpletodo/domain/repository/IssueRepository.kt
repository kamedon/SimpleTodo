package com.kamedon.simpletodo.domain.repository

import com.kamedon.simpletodo.domain.entity.Issue

interface IIssueRepository {
    suspend fun save(issue: Issue)

}

class IssueRepository : IIssueRepository {
    override suspend fun save(issue: Issue) {
    }
}
