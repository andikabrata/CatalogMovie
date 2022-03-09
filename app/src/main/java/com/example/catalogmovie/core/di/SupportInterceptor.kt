package com.example.catalogmovie.core.di

import okhttp3.Interceptor
import okhttp3.Response

/**
 * Created by dwiss.purwoko@gmail.com on 16/08/2021.
 */

class SupportInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        request = request.newBuilder()
            .header("Content-Type", "application/json")
            .removeHeader("Pragma")
            .header("Cache-Control", String.format("max-age=%d", 432000))
            .build()
        return chain.proceed(request)
    }
}