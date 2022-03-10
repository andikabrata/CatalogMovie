package com.example.catalogmovie.core.di

import com.example.catalogmovie.feature.catalog_movie.di.listMovieViewModel


/**
 * List of modules
 */
val appComponent = listOf(
    coreModule,
    retrofitModule,
    listMovieViewModel
)
