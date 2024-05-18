package com.memo.app.infrastructure.database.mapper

import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.Memos
import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.Users
import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.memoId
import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.title
import com.memo.app.infrastructure.database.mapper.MemosDynamicSqlSupport.userId
import com.memo.app.infrastructure.database.mapper.UsersDynamicSqlSupport.userName
import com.memo.app.infrastructure.database.record.MemoWithUser
import org.mybatis.dynamic.sql.SqlBuilder.on
import org.mybatis.dynamic.sql.util.kotlin.mybatis3.*

//fun MemoWithUserMapper.select(): List<MemoWithUser> {
//
//    val selectStatement =
//        select(memoId, userId, userId, userName) {
//          from(Memos, "m")
//          fullJoin(Users) {
//            on(Memos.) equatTo(Users.)
//          }
//        }
//
//    return selectMany(selectStatement)
//}
