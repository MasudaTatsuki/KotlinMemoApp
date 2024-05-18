/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.memo.app.infrastructure.database.record

import java.time.LocalDateTime

data class Users(
    var userId: Int? = null,
    var userName: String? = null,
    var email: String? = null,
    var passwordHash: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null
)