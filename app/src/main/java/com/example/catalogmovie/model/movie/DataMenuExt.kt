package com.example.catalogmovie.model.movie

import com.example.catalogmovie.R
import com.example.catalogmovie.feature.catalog_movie.ui.MovieFragment
import com.example.catalogmovie.model.menu.MenuProject

object DataMenuExt {

    fun fetchDataMenu(context: MovieFragment): ArrayList<MenuProject> {
        val menuList = ArrayList<MenuProject>()
        menuList.add(
            MenuProject(
                R.drawable.ic_top_rtaed_movie,
                context.getString(R.string.top_rated_movies)
            )
        )
        menuList.add(
            MenuProject(
                R.drawable.ic_upcoming_movie,
                context.getString(R.string.upcoming_movies)
            )
        )
        menuList.add(
            MenuProject(
                R.drawable.ic_now_playing_movie,
                context.getString(R.string.now_playing_movies)
            )
        )
        menuList.add(
            MenuProject(
                R.drawable.ic_popular_movie,
                context.getString(R.string.popular_movies)
            )
        )
        return menuList
    }
}