package com.memo.app.domain.model

data class User(
    var userId: Int,
    var userName: String,
    var email: String?,
    var password: String?
)