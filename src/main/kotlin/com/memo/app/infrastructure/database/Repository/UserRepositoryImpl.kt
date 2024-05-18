package com.memo.app.infrastructure.database.Repository

import com.memo.app.domain.model.User
import com.memo.app.domain.repositry.UserRepository
import com.memo.app.infrastructure.database.mapper.UsersMapper
import com.memo.app.infrastructure.database.mapper.selectByEmail
import com.memo.app.infrastructure.database.record.Users
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl(
    private val mapper: UsersMapper
) : UserRepository {

    override fun find(email: String): User? {

        val record = mapper.selectByEmail(email)
        return record?.let { toModel(record) }
    }

    private fun toModel(record: Users): User {

        return User(
            record.userId!!,
            record.userName!!,
            record.email!!,
            record.passwordHash!!
        )
    }
}