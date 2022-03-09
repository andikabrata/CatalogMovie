package com.example.catalogmovie.core.base


class BaseResponse<T : Any> {
    val status = 0
    val message: String = ""
    val data: T? = null
}