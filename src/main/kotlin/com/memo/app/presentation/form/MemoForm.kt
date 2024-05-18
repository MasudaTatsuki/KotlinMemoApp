package com.memo.app.presentation.form

import com.memo.app.domain.model.MemoWithUser
import java.time.LocalDateTime

data class GetMemoListResponse(val memoList: List<MemoInfo>)

data class GetMemoDetailResponse(
    val memoId: Int?,
    val title: String,
    val content: String,
) {
    constructor(model: MemoWithUser) : this(
        model.memo.memoId,
        model.memo.title,
        model.memo.content
    )
}

data class MemoInfo(
    val memoId: Int?,
    val userName: String?,
    val title: String,
    val updatedAt: LocalDateTime
) {
    constructor(model: MemoWithUser): this(
        model.memo.memoId,
        model.user.userName,
        model.memo.title,
        model.memo.updatedAt)
}

data class RegisterMemoRequest(
    val userId: Int,
    val title: String,
    val content: String
)

data class UpdateMemoRequest(
    val memoId: Int,
    val title: String?,
    val content: String?,
    val updatedAt: LocalDateTime?
)