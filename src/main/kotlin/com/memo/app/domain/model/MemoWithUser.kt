package com.memo.app.domain.model

data class MemoWithUser (
    val memo: Memo,
    val user: User
)