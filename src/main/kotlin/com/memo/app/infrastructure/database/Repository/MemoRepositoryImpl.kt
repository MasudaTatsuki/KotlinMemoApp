package com.memo.app.infrastructure.database.Repository

import com.memo.app.domain.model.Memo
import com.memo.app.domain.model.MemoWithUser
import com.memo.app.domain.model.User
import com.memo.app.domain.repositry.MemoRepository
import com.memo.app.infrastructure.database.mapper.*
import com.memo.app.infrastructure.database.record.Memos
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class MemoRepositoryImpl(
    private val memoWithUserMapper: MemoWithUserMapper,
    private val memosMapper: MemosMapper
) : MemoRepository {
    override fun findAll(): List<MemoWithUser> {
        return memoWithUserMapper.select().map { toModel(it) }
    }

    override fun find(id: Int?): MemoWithUser? {
        return memoWithUserMapper.selectByPrimaryKey(id)?.let { toModel(it) }
    }

    private fun toModel(record: com.memo.app.infrastructure.database.record.MemoWithUser): MemoWithUser {
        val memo = Memo(
            record.memoId!!,
            record.userId!!,
            record.title!!,
            record.updatedAt!!,
            record.content!!
        )

        val user = User(
                record.userId!!,
                record.userName!!,
                null,
            null
            )

        return MemoWithUser(memo, user)

    }

    override fun register(memo: Memo) {
        memosMapper.insert(toRecord(memo))
    }

    private fun toRecord(model: Memo): Memos {
        return Memos(model.memoId, model.userId, model.title,model.updatedAt, model.updatedAt, model.content)
    }

    override fun update(memoId: Int, title: String?, content: String?, updatedAt: LocalDateTime?) {
        memosMapper.updateByPrimaryKey(
            Memos(memoId, null, title, null, updatedAt, content)
        )
    }

    override fun delete(memoId: Int) {
        memosMapper.deleteByPrimaryKey(memoId)
    }
}