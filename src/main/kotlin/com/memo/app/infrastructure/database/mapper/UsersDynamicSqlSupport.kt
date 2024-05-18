/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.memo.app.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object UsersDynamicSqlSupport {
    val users = Users()

    val userId = users.userId

    val userName = users.userName

    val email = users.email

    val passwordHash = users.passwordHash

    val createdAt = users.createdAt

    val updatedAt = users.updatedAt

    class Users : AliasableSqlTable<Users>("users", ::Users) {
        val userId = column<Int>(name = "user_id", jdbcType = JDBCType.INTEGER)

        val userName = column<String>(name = "user_name", jdbcType = JDBCType.VARCHAR)

        val email = column<String>(name = "email", jdbcType = JDBCType.VARCHAR)

        val passwordHash = column<String>(name = "password_hash", jdbcType = JDBCType.VARCHAR)

        val createdAt = column<LocalDateTime>(name = "created_at", jdbcType = JDBCType.TIMESTAMP)

        val updatedAt = column<LocalDateTime>(name = "updated_at", jdbcType = JDBCType.TIMESTAMP)
    }
}