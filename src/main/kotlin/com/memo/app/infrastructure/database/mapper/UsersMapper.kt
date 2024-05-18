/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.memo.app.infrastructure.database.mapper

import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.createdAt
import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.email
import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.passwordHash
import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.updatedAt
import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.userId
import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.userName
import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.users
import com.memo.app.infrastructure.database.record.Users
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Result
import org.apache.ibatis.annotations.ResultMap
import org.apache.ibatis.annotations.Results
import org.apache.ibatis.annotations.SelectProvider
import org.apache.ibatis.type.JdbcType
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider
import org.mybatis.dynamic.sql.util.SqlProviderAdapter
import org.mybatis.dynamic.sql.util.kotlin.CountCompleter
import org.mybatis.dynamic.sql.util.kotlin.DeleteCompleter
import org.mybatis.dynamic.sql.util.kotlin.KotlinUpdateBuilder
import org.mybatis.dynamic.sql.util.kotlin.SelectCompleter
import org.mybatis.dynamic.sql.util.kotlin.UpdateCompleter
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.countFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.deleteFrom
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insert
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.insertMultiple
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectDistinct
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectList
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.selectOne
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.update
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper

@Mapper
interface UsersMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Users>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="UsersResult", value = [
        Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR),
        Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        Result(column="password_hash", property="passwordHash", jdbcType=JdbcType.VARCHAR),
        Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Users>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("UsersResult")
    fun selectOne(selectStatement: SelectStatementProvider): Users?
}

fun UsersMapper.count(completer: CountCompleter) =
    countFrom(this::count, users, completer)

fun UsersMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, users, completer)

fun UsersMapper.deleteByPrimaryKey(userId_: Int) =
    delete {
        where { userId isEqualTo userId_ }
    }

fun UsersMapper.insert(row: Users) =
    insert(this::insert, row, users) {
        map(userId) toProperty "userId"
        map(userName) toProperty "userName"
        map(email) toProperty "email"
        map(passwordHash) toProperty "passwordHash"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun UsersMapper.insertMultiple(records: Collection<Users>) =
    insertMultiple(this::insertMultiple, records, users) {
        map(userId) toProperty "userId"
        map(userName) toProperty "userName"
        map(email) toProperty "email"
        map(passwordHash) toProperty "passwordHash"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
    }

fun UsersMapper.insertMultiple(vararg records: Users) =
    insertMultiple(records.toList())

fun UsersMapper.insertSelective(row: Users) =
    insert(this::insert, row, users) {
        map(userId).toPropertyWhenPresent("userId", row::userId)
        map(userName).toPropertyWhenPresent("userName", row::userName)
        map(email).toPropertyWhenPresent("email", row::email)
        map(passwordHash).toPropertyWhenPresent("passwordHash", row::passwordHash)
        map(createdAt).toPropertyWhenPresent("createdAt", row::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", row::updatedAt)
    }

private val columnList = listOf(userId, userName, email, passwordHash, createdAt, updatedAt)

fun UsersMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, users, completer)

fun UsersMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, users, completer)

fun UsersMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, users, completer)

fun UsersMapper.selectByPrimaryKey(userId_: Int) =
    selectOne {
        where { userId isEqualTo userId_ }
    }

fun UsersMapper.selectByEmail(email_: String) =
    selectOne {
        where { email isEqualTo email_}
    }

fun UsersMapper.update(completer: UpdateCompleter) =
    update(this::update, users, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Users) =
    apply {
        set(userId) equalToOrNull row::userId
        set(userName) equalToOrNull row::userName
        set(email) equalToOrNull row::email
        set(passwordHash) equalToOrNull row::passwordHash
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Users) =
    apply {
        set(userId) equalToWhenPresent row::userId
        set(userName) equalToWhenPresent row::userName
        set(email) equalToWhenPresent row::email
        set(passwordHash) equalToWhenPresent row::passwordHash
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
    }

fun UsersMapper.updateByPrimaryKey(row: Users) =
    update {
        set(userName) equalToOrNull row::userName
        set(email) equalToOrNull row::email
        set(passwordHash) equalToOrNull row::passwordHash
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
        where { userId isEqualTo row.userId!! }
    }

fun UsersMapper.updateByPrimaryKeySelective(row: Users) =
    update {
        set(userName) equalToWhenPresent row::userName
        set(email) equalToWhenPresent row::email
        set(passwordHash) equalToWhenPresent row::passwordHash
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
        where { userId isEqualTo row.userId!! }
    }