package com.memo.app.infrastructure.database.record

import java.time.LocalDateTime

data class MemoWithUser (
    var memoId: Int? = null,
    var userId: Int? = null,
    var userName: String? = null,
    var title: String? = null,
    var content: String? = null,
    var email: String? = null,
    var passwordHash: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
)