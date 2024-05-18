package com.memo.app.application.service

import com.memo.app.domain.model.Memo
import com.memo.app.domain.model.MemoWithUser
import com.memo.app.domain.repositry.MemoRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime

@Service
class MemoService(
    private val memoRepository: MemoRepository
) {

    fun getList(): List<MemoWithUser> {
        return memoRepository.findAll()
    }

    fun getDetail(memoId: Int): MemoWithUser {
        return memoRepository.find(memoId) ?: throw IllegalArgumentException("存在しないメモID: $memoId")
    }

    @Transactional
    fun register(memo: Memo) {
//        memoRepository.find(memo.memoId)?.let {
//            throw IllegalArgumentException("すでに存在するメモID: ${memo.memoId}")
//        }
        memoRepository.register(memo)
    }

    @Transactional
    fun update(memoId: Int, title: String?, content: String?, updatedAt: LocalDateTime?) {
        memoRepository.find(memoId) ?: throw IllegalArgumentException("存在しないメモID: $memoId")
        memoRepository.update(memoId, title, content, updatedAt)
    }

    @Transactional
    fun delete(memoId: Int) {
        memoRepository.find(memoId) ?: throw IllegalArgumentException("存在しないメモID: $memoId")
        memoRepository.delete(memoId)
    }
}