package com.example.catalogmovie.core.api

import com.example.catalogmovie.model.movie.BaseResponseList
import com.example.catalogmovie.model.movie.Movie
import com.example.catalogmovie.model.tv.Tv
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ServiceApi {

    @GET("{category}/top_rated")
    suspend fun getTopRatedMovie(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?
    ): BaseResponseList<Movie>

    @GET("{category}/upcoming")
    suspend fun getUpcomingMovie(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?
    ): BaseResponseList<Movie>

    @GET("{category}/now_playing")
    suspend fun getNowPlayingMovie(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?
    ): BaseResponseList<Movie>

    @GET("{category}/popular")
    suspend fun getPopularMovie(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?
    ): BaseResponseList<Movie>

    @GET("{category}/popular")
    suspend fun getPopularTv(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?
    ): BaseResponseList<Tv>

    @GET("{category}/top_rated")
    suspend fun getTopRatedTv(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?
    ): BaseResponseList<Tv>

    @GET("{category}/on_the_air")
    suspend fun getOnAirTv(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?
    ): BaseResponseList<Tv>

    @GET("{category}/airing_today")
    suspend fun getAiringTv(
        @Path("category") category: String?,
        @Query("api_key") apiKey: String?
    ): BaseResponseList<Tv>

//    @GET("search/{category}")
//    fun searchMovie(
//        @Path("category") category: String?,
//        @Query("api_key") apiKey: String?,
//        @Query("query") query: String?
//    ): Call<APIResponse>?

}