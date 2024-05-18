/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.memo.app.infrastructure.database.mapper

import java.sql.JDBCType
import java.time.LocalDateTime
import org.mybatis.dynamic.sql.AliasableSqlTable
import org.mybatis.dynamic.sql.util.kotlin.elements.column

object MemosDynamicSqlSupport {
    val memos = Memos()

    val memoId = memos.memoId

    val userId = memos.userId

    val title = memos.title

    val createdAt = memos.createdAt

    val updatedAt = memos.updatedAt

    val content = memos.content

    class Memos : AliasableSqlTable<Memos>("memos", ::Memos) {
        val memoId = column<Int>(name = "memo_id", jdbcType = JDBCType.INTEGER)

        val userId = column<Int>(name = "user_id", jdbcType = JDBCType.INTEGER)

        val title = column<String>(name = "title", jdbcType = JDBCType.VARCHAR)

        val createdAt = column<LocalDateTime>(name = "created_at", jdbcType = JDBCType.TIMESTAMP)

        val updatedAt = column<LocalDateTime>(name = "updated_at", jdbcType = JDBCType.TIMESTAMP)

        val content = column<String>(name = "content", jdbcType = JDBCType.LONGVARCHAR)
    }
}