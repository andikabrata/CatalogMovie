package com.example.catalogmovie.feature.catalog_tv.di

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
import com.example.catalogmovie.model.tv.Tv

class ListTvViewModel(
    private val serviceUtil: ServiceApi,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    val listPopularTvLiveData = MutableLiveData<ViewState<BaseResponseList<Tv>>>()
    val listTopRatedTvLiveData = MutableLiveData<ViewState<BaseResponseList<Tv>>>()
    val listOnAirTvLiveData = MutableLiveData<ViewState<BaseResponseList<Tv>>>()
    val listAiringTvLiveData = MutableLiveData<ViewState<BaseResponseList<Tv>>>()

    fun getListPopularTv() {
        listPopularTvLiveData.setLoading()
        launchOnUi(
            dispatcher = dispatchers,
            onRequest = {
                val result = serviceUtil.getPopularTv(CATEGORY, BuildConfig.API_KEY)
                listPopularTvLiveData.setSuccess(result)
            },
            onError = {
                listPopularTvLiveData.setError(it)
            }
        )
    }

    fun getListTopRatedTv() {
        listTopRatedTvLiveData.setLoading()
        launchOnUi(
            dispatcher = dispatchers,
            onRequest = {
                val result = serviceUtil.getTopRatedTv(CATEGORY, BuildConfig.API_KEY)
                listTopRatedTvLiveData.setSuccess(result)
            },
            onError = {
                listTopRatedTvLiveData.setError(it)
            }
        )
    }

    fun getListOnAirTv() {
        listOnAirTvLiveData.setLoading()
        launchOnUi(
            dispatcher = dispatchers,
            onRequest = {
                val result = serviceUtil.getOnAirTv(CATEGORY, BuildConfig.API_KEY)
                listOnAirTvLiveData.setSuccess(result)
            },
            onError = {
                listOnAirTvLiveData.setError(it)
            }
        )
    }

    fun getListAiringTv() {
        listAiringTvLiveData.setLoading()
        launchOnUi(
            dispatcher = dispatchers,
            onRequest = {
                val result = serviceUtil.getAiringTv(CATEGORY, BuildConfig.API_KEY)
                listAiringTvLiveData.setSuccess(result)
            },
            onError = {
                listAiringTvLiveData.setError(it)
            }
        )
    }

    companion object {
        private const val CATEGORY = "tv"
    }
}