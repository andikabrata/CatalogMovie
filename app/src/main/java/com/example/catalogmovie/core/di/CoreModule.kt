package com.example.catalogmovie.core.di

import com.example.catalogmovie.common.utils.AppDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val coreModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
}