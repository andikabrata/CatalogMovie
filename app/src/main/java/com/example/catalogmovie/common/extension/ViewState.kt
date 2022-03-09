package com.example.catalogmovie.common.extension

import androidx.lifecycle.MutableLiveData

/**
 * Created by dwiss.purwoko@gmail.com on 16/08/2021.
 */

sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Failed(val message: String?) : ViewState<Nothing>()
}

fun <T> MutableLiveData<ViewState<T>>.setSuccess(data: T? = null) =
    if (data != null) {
        postValue(ViewState.Success(data))
    } else {
        postValue(ViewState.Failed("Data Null"))
    }


fun <T> MutableLiveData<ViewState<T>>.setLoading() =
    postValue(ViewState.Loading)

fun <T> MutableLiveData<ViewState<T>>.setError(message: String? = null) =
    postValue(ViewState.Failed(message))
