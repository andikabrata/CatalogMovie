package com.example.catalogmovie.model.tv

import com.example.catalogmovie.R
import com.example.catalogmovie.feature.catalog_tv.ui.TvFragment
import com.example.catalogmovie.model.menu.MenuProject

object DataMenuTvExt {
    fun fetchDataMenu(context: TvFragment): ArrayList<MenuProject> {
        val menuList = ArrayList<MenuProject>()
        menuList.add(
            MenuProject(
                R.drawable.ic_popular_tv,
                context.getString(R.string.popular_tv_shows)
            )
        )
        menuList.add(
            MenuProject(
                R.drawable.ic_top_rated_tv,
                context.getString(R.string.top_rated_tv_shows)
            )
        )
        menuList.add(
            MenuProject(
                R.drawable.ic_on_air_tv,
                context.getString(R.string.on_air_tv_shows)
            )
        )
        menuList.add(
            MenuProject(
                R.drawable.ic_airing_tv,
                context.getString(R.string.airing_today_tv_shows)
            )
        )
        return menuList
    }
}