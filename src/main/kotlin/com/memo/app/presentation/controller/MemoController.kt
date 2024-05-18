package com.memo.app.presentation.controller

import com.memo.app.application.service.MemoService
import com.memo.app.domain.model.Memo
import com.memo.app.presentation.form.*
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime

@RestController
@RequestMapping("memo")
@CrossOrigin
class MemoController(
    private val memoService: MemoService
) {
    @GetMapping("/list")
    fun getList(): GetMemoListResponse {

        val memoList = memoService.getList().map {
            MemoInfo(it)
        }

        return GetMemoListResponse(memoList)
    }

    @GetMapping("/detail/{memo_id}")
    fun getDetail(@PathVariable("memo_id") memoId: Int): GetMemoDetailResponse {
        val memo = memoService.getDetail(memoId)
        return GetMemoDetailResponse(memo)
    }

    @PostMapping("/register")
    fun register(@RequestBody request: RegisterMemoRequest) {
        memoService.register(
            Memo(
                null,
                request.userId,
                request.title,
                LocalDateTime.now(),
                request.content
            )
        )
    }

    @PutMapping("/update")
    fun update(@RequestBody request: UpdateMemoRequest) {
        memoService.update(
            request.memoId,
            request.title,
            request.content,
            request.updatedAt
        )
    }

    @DeleteMapping("/delete/{memo_id}")
    fun delete(@PathVariable("memo_id") memoId: Int) {
        memoService.delete(memoId)
    }
}