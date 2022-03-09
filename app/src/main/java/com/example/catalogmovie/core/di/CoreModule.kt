package com.example.catalogmovie.core.di

import com.example.catalogmovie.common.utils.AppDispatchers
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

/**
 * Created by dwiss.purwoko@gmail.com on 16/08/2021.
 */

val coreModule = module {
    factory { AppDispatchers(Dispatchers.Main, Dispatchers.IO) }
}