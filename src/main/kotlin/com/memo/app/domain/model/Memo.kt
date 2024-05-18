package com.memo.app.domain.model

import java.time.LocalDateTime

data class Memo(
    var memoId: Int?,
    var userId: Int,
    var title: String,
    var updatedAt: LocalDateTime,
    var content: String
)