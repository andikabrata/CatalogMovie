package com.example.catalogmovie.feature.catalog_tv.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val listTvViewModel = module  {
    viewModel {
        ListTvViewModel(get(), get())
    }
}