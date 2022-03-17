package com.example.catalogmovie.model.movie

data class Movie (
    val id: Int,
    val title: String,
    val overview: String,
    val release_date: String,
    val poster_path: String,
    val vote_average: String
)