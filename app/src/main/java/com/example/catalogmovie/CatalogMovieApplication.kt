package com.example.catalogmovie

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.example.catalogmovie.core.di.appComponent
import com.github.ajalt.timberkt.Timber
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.core.module.Module

class CatalogMovieApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        instance = this

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@CatalogMovieApplication)
            modules(provideComponent())
        }

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    /**
     * provide list of modules @see [appComponent]
     */
    private fun provideComponent(): List<Module> {
        return appComponent
    }

    companion object {
        lateinit var instance: CatalogMovieApplication
            private set
    }
}