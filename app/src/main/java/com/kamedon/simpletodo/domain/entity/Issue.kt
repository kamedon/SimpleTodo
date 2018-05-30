package com.kamedon.simpletodo.domain.entity

import java.util.*

data class Issue(val id: String = UUID.randomUUID().toString(),
                 val body: String)