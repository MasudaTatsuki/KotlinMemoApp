package com.memo.app.application.service

import com.memo.app.domain.model.User
import com.memo.app.domain.repositry.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthenticationService(
    private val userRepository: UserRepository
) {

    fun findUser(email: String): User? {
        return userRepository.find(email)
    }
}