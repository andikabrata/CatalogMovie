package com.example.catalogmovie.model.movie

data class Movie (
    val id: Int,
    val title: String,
    val name: String,
    val overview: String,
    val release_date: String,
    val first_air_date: String,
    val poster_path: String
)