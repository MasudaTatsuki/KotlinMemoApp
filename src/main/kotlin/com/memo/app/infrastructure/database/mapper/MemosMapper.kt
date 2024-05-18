/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.memo.app.infrastructure.database.mapper

import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.content
import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.createdAt
import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.memoId
import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.memos
import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.title
import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.updatedAt
import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.userId
import com.memo.app.infrastructure.database.record.Memos
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
interface MemosMapper : CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Memos>, CommonUpdateMapper {
    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @Results(id="MemosResult", value = [
        Result(column="memo_id", property="memoId", jdbcType=JdbcType.INTEGER, id=true),
        Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        Result(column="created_at", property="createdAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="updated_at", property="updatedAt", jdbcType=JdbcType.TIMESTAMP),
        Result(column="content", property="content", jdbcType=JdbcType.LONGVARCHAR)
    ])
    fun selectMany(selectStatement: SelectStatementProvider): List<Memos>

    @SelectProvider(type=SqlProviderAdapter::class, method="select")
    @ResultMap("MemosResult")
    fun selectOne(selectStatement: SelectStatementProvider): Memos?
}

fun MemosMapper.count(completer: CountCompleter) =
    countFrom(this::count, memos, completer)

fun MemosMapper.delete(completer: DeleteCompleter) =
    deleteFrom(this::delete, memos, completer)

fun MemosMapper.deleteByPrimaryKey(memoId_: Int) =
    delete {
        where { memoId isEqualTo memoId_ }
    }

fun MemosMapper.insert(row: Memos) =
    insert(this::insert, row, memos) {
        map(memoId) toProperty "memoId"
        map(userId) toProperty "userId"
        map(title) toProperty "title"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
        map(content) toProperty "content"
    }

fun MemosMapper.insertMultiple(records: Collection<Memos>) =
    insertMultiple(this::insertMultiple, records, memos) {
        map(memoId) toProperty "memoId"
        map(userId) toProperty "userId"
        map(title) toProperty "title"
        map(createdAt) toProperty "createdAt"
        map(updatedAt) toProperty "updatedAt"
        map(content) toProperty "content"
    }

fun MemosMapper.insertMultiple(vararg records: Memos) =
    insertMultiple(records.toList())

fun MemosMapper.insertSelective(row: Memos) =
    insert(this::insert, row, memos) {
        map(memoId).toPropertyWhenPresent("memoId", row::memoId)
        map(userId).toPropertyWhenPresent("userId", row::userId)
        map(title).toPropertyWhenPresent("title", row::title)
        map(createdAt).toPropertyWhenPresent("createdAt", row::createdAt)
        map(updatedAt).toPropertyWhenPresent("updatedAt", row::updatedAt)
        map(content).toPropertyWhenPresent("content", row::content)
    }

private val columnList = listOf(memoId, userId, title, createdAt, updatedAt, content)

fun MemosMapper.selectOne(completer: SelectCompleter) =
    selectOne(this::selectOne, columnList, memos, completer)

fun MemosMapper.select(completer: SelectCompleter) =
    selectList(this::selectMany, columnList, memos, completer)

fun MemosMapper.selectDistinct(completer: SelectCompleter) =
    selectDistinct(this::selectMany, columnList, memos, completer)

fun MemosMapper.selectByPrimaryKey(memoId_: Int) =
    selectOne {
        where { memoId isEqualTo memoId_ }
    }

fun MemosMapper.update(completer: UpdateCompleter) =
    update(this::update, memos, completer)

fun KotlinUpdateBuilder.updateAllColumns(row: Memos) =
    apply {
        set(memoId) equalToOrNull row::memoId
        set(userId) equalToOrNull row::userId
        set(title) equalToOrNull row::title
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
        set(content) equalToOrNull row::content
    }

fun KotlinUpdateBuilder.updateSelectiveColumns(row: Memos) =
    apply {
        set(memoId) equalToWhenPresent row::memoId
        set(userId) equalToWhenPresent row::userId
        set(title) equalToWhenPresent row::title
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
        set(content) equalToWhenPresent row::content
    }

fun MemosMapper.updateByPrimaryKey(row: Memos) =
    update {
        set(userId) equalToOrNull row::userId
        set(title) equalToOrNull row::title
        set(createdAt) equalToOrNull row::createdAt
        set(updatedAt) equalToOrNull row::updatedAt
        set(content) equalToOrNull row::content
        where { memoId isEqualTo row.memoId!! }
    }

fun MemosMapper.updateByPrimaryKeySelective(row: Memos) =
    update {
        set(userId) equalToWhenPresent row::userId
        set(title) equalToWhenPresent row::title
        set(createdAt) equalToWhenPresent row::createdAt
        set(updatedAt) equalToWhenPresent row::updatedAt
        set(content) equalToWhenPresent row::content
        where { memoId isEqualTo row.memoId!! }
    }