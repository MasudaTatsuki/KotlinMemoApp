/*
 * Auto-generated file. Created by MyBatis Generator
 */
package com.memo.app.infrastructure.database.record

import java.time.LocalDateTime

data class Memos(
    var memoId: Int? = null,
    var userId: Int? = null,
    var title: String? = null,
    var createdAt: LocalDateTime? = null,
    var updatedAt: LocalDateTime? = null,
    var content: String? = null
)