package com.example.catalogmovie.model.movie

data class BaseResponseList<T> (
    val page: String, val results: List<T>?
)