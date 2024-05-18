package com.memo.app.domain.repositry

import com.memo.app.domain.model.User

interface UserRepository {
    fun find(email: String): User?
}