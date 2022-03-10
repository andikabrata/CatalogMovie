package com.example.catalogmovie.feature.catalog_movie.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listMovieViewModel = module  {
    viewModel {
        ListMovieViewModel(get(), get())
    }
}