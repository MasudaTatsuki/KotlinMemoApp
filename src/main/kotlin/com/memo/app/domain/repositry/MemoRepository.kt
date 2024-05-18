package com.memo.app.domain.repositry

import com.memo.app.domain.model.Memo
import com.memo.app.domain.model.MemoWithUser
import java.time.LocalDateTime

interface MemoRepository {
    fun findAll(): List<MemoWithUser>
    fun find(id: Int?): MemoWithUser?
    fun register(memo: Memo)
    fun update(memoId: Int, title: String?, content: String?, updatedAt: LocalDateTime?)
    fun delete(memoId: Int)
}