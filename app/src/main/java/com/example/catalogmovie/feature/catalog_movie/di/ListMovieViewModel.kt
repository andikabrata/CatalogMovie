package com.example.catalogmovie.feature.catalog_movie.di

import androidx.lifecycle.MutableLiveData
import com.example.catalogmovie.BuildConfig
import com.example.catalogmovie.common.extension.ViewState
import com.example.catalogmovie.common.extension.setError
import com.example.catalogmovie.common.extension.setLoading
import com.example.catalogmovie.common.extension.setSuccess
import com.example.catalogmovie.common.utils.AppDispatchers
import com.example.catalogmovie.core.api.ServiceApi
import com.example.catalogmovie.core.base.BaseViewModel
import com.example.catalogmovie.model.movie.BaseResponseList
import com.example.catalogmovie.model.movie.Movie

class ListMovieViewModel(
    private val serviceUtil: ServiceApi,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    val listTopRatedMovieLiveData = MutableLiveData<ViewState<BaseResponseList<Movie>>>()
    val listUpcomingMovieLiveData = MutableLiveData<ViewState<BaseResponseList<Movie>>>()
    val listNowPlayingMovieLiveData = MutableLiveData<ViewState<BaseResponseList<Movie>>>()
    val listPopularMovieLiveData = MutableLiveData<ViewState<BaseResponseList<Movie>>>()

    fun getListTopRatedMovie() {
        listTopRatedMovieLiveData.setLoading()
        launchOnUi(
            dispatcher = dispatchers,
            onRequest = {
                val result = serviceUtil.getTopRatedMovie(CATEGORY, BuildConfig.API_KEY)
                listTopRatedMovieLiveData.setSuccess(result)
            },
            onError = {
                listTopRatedMovieLiveData.setError(it)
            }
        )
    }

    fun getListUpcomingMovie() {
        listUpcomingMovieLiveData.setLoading()
        launchOnUi(
            dispatcher = dispatchers,
            onRequest = {
                val result = serviceUtil.getUpcomingMovie(CATEGORY, BuildConfig.API_KEY)
                listUpcomingMovieLiveData.setSuccess(result)
            },
            onError = {
                listUpcomingMovieLiveData.setError(it)
            }
        )
    }

    fun getListNowPlayingMovie() {
        listNowPlayingMovieLiveData.setLoading()
        launchOnUi(
            dispatcher = dispatchers,
            onRequest = {
                val result = serviceUtil.getNowPlayingMovie(CATEGORY, BuildConfig.API_KEY)
                listNowPlayingMovieLiveData.setSuccess(result)
            },
            onError = {
                listNowPlayingMovieLiveData.setError(it)
            }
        )
    }

    fun getListPopularMovie() {
        listPopularMovieLiveData.setLoading()
        launchOnUi(
            dispatcher = dispatchers,
            onRequest = {
                val result = serviceUtil.getPopularMovie(CATEGORY, BuildConfig.API_KEY)
                listPopularMovieLiveData.setSuccess(result)
            },
            onError = {
                listPopularMovieLiveData.setError(it)
            }
        )
    }

    companion object {
        private const val CATEGORY = "movie"
    }
}