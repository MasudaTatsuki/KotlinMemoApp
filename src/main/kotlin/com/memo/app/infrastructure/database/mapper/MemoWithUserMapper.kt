package com.memo.app.infrastructure.database.mapper

import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.memos
import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.users
import com.memo.app.infrastructure.database.record.MemoWithUser
import org.apache.ibatis.annotations.*
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*
import org.mybatis.dynamic.sql.util.mybatis3.CommonSelectMapper

@Mapper
interface MemoWithUserMapper  : CommonSelectMapper {
    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @Results(
        id = "MemoWithUserResult",
        value = [
            Result(column = "memo_id", property = "memoId", jdbcType = JdbcType.BIGINT, id = true),
            Result(column = "user_id", property = "userId", jdbcType = JdbcType.BIGINT),
            Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
            Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
            Result(column = "updated_at", property = "updatedAt", jdbcType = JdbcType.VARCHAR),
            Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR)
        ]
    )
    fun selectMany(selectStatement: SelectStatementProvider): List<MemoWithUser>

    @SelectProvider(type = SqlProviderAdapter::class, method = "select")
    @ResultMap("MemoWithUserResult")
    fun selectOne(selectStatement: SelectStatementProvider): MemoWithUser?
}

fun MemoWithUserMapper.select(): List<MemoWithUser> {

    val selectStatement = select(
        memos.memoId, memos.userId, memos.title, memos.updatedAt, memos.content,
        users.userId, users.userName
    ) {
        from(memos)
        join(users) {
            on(memos.userId) equalTo users.userId
        }
    }

    return selectMany(selectStatement)
}

fun MemoWithUserMapper.selectByPrimaryKey(id_: Int?): MemoWithUser? {

    val selectStatement = select(
        memos.memoId, memos.content, memos.title, memos.content, memos.updatedAt,
        users.userId, users.userName

    ) {
        from(memos)
        join(users) {
            on(memos.userId) equalTo users.userId
        }
        where{
            memos.memoId isEqualTo  id_!!
        }
    }

    return selectOne(selectStatement)
}