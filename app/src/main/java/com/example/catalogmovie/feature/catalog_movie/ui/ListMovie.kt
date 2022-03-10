package com.example.catalogmovie.feature.catalog_movie.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.example.catalogmovie.R
import com.example.catalogmovie.common.extension.*
import com.example.catalogmovie.core.base.BaseVMActivity
import com.example.catalogmovie.databinding.ActivityListMovieBinding
import com.example.catalogmovie.feature.OnFilterDialogListener
import com.example.catalogmovie.feature.catalog_movie.adapter.MovieAdapter
import com.example.catalogmovie.feature.catalog_movie.di.ListMovieViewModel
import com.example.catalogmovie.feature.detial_content.ui.DetailActivity

class ListMovie : BaseVMActivity<ListMovieViewModel, ActivityListMovieBinding>(),
    OnFilterDialogListener {

    private var toolbarValue: String = ""
    private var typeMovie: String = ""

    val adapter by lazy {
        MovieAdapter() {
            startActivity<DetailActivity> {
                putExtra("title",it.title)
                putExtra("date",it.release_date)
                putExtra("overview",it.overview)
                putExtra("image_path",it.poster_path)
            }
        }
    }

    override fun getViewModel() = ListMovieViewModel::class.java

    override fun getViewBinding(): ActivityListMovieBinding {
        return ActivityListMovieBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        toolbarValue = intent.getStringExtra("toolbar").orEmpty()
        typeMovie = intent.getStringExtra("typeMovie").orEmpty()

        initToolbar(binding.toolbar, toolbarValue, back = true)

        if (typeMovie == "Top Rated Movies") {
            viewModel.getListTopRatedMovie()
        } else if (typeMovie == "Upcoming Movies") {
            viewModel.getListUpcomingMovie()
        } else if (typeMovie == "Now Playing Movies") {
            viewModel.getListNowPlayingMovie()
        } else if (typeMovie == "Popular Movies") {
            viewModel.getListPopularMovie()
        }

        binding.listMovies.apply {
            gridLayoutManager(1)
        }
    }

    override fun observerViewModel() {
        viewModel.listTopRatedMovieLiveData.onResult { state ->
            when (state) {
                is ViewState.Loading -> {
                    binding.stateLayout.toLoading()
                }

                is ViewState.Success -> {
                    if (state.data.results?.isNotEmpty().orFalse()) {
                        binding.stateLayout.toContent()
                        state.data.results?.let { adapter.addData(it) }
                        binding.listMovies.adapter = adapter
                    } else
                        binding.stateLayout.toEmpty()
                }

                is ViewState.Failed -> {

                }
            }
        }

        viewModel.listUpcomingMovieLiveData.onResult { state ->
            when (state) {
                is ViewState.Loading -> {
                    binding.stateLayout.toLoading()
                }

                is ViewState.Success -> {
                    if (state.data.results?.isNotEmpty().orFalse()) {
                        binding.stateLayout.toContent()
                        state.data.results?.let { adapter.addData(it) }
                        binding.listMovies.adapter = adapter
                    } else
                        binding.stateLayout.toEmpty()
                }

                is ViewState.Failed -> {

                }
            }
        }

        viewModel.listPopularMovieLiveData.onResult { state ->
            when (state) {
                is ViewState.Loading -> {
                    binding.stateLayout.toLoading()
                }

                is ViewState.Success -> {
                    if (state.data.results?.isNotEmpty().orFalse()) {
                        binding.stateLayout.toContent()
                        state.data.results?.let { adapter.addData(it) }
                        binding.listMovies.adapter = adapter
                    } else
                        binding.stateLayout.toEmpty()
                }

                is ViewState.Failed -> {

                }
            }
        }

        viewModel.listNowPlayingMovieLiveData.onResult { state ->
            when (state) {
                is ViewState.Loading -> {
                    binding.stateLayout.toLoading()
                }

                is ViewState.Success -> {
                    if (state.data.results?.isNotEmpty().orFalse()) {
                        binding.stateLayout.toContent()
                        state.data.results?.let { adapter.addData(it) }
                        binding.listMovies.adapter = adapter
                    } else
                        binding.stateLayout.toEmpty()
                }

                is ViewState.Failed -> {

                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_gallery, menu)

        val searchItem = menu?.findItem(R.id.action_search)
        val searchView = searchItem?.actionView as SearchView

        searchItem.setOnActionExpandListener(object : MenuItem.OnActionExpandListener {
            override fun onMenuItemActionExpand(menuItem: MenuItem): Boolean {
                return true
            }

            override fun onMenuItemActionCollapse(menuItem: MenuItem): Boolean {
                if (typeMovie == "Top Rated Movies") {
                    viewModel.getListTopRatedMovie()
                } else if (typeMovie == "Upcoming Movies") {
                    viewModel.getListUpcomingMovie()
                } else if (typeMovie == "Now Playing Movies") {
                    viewModel.getListNowPlayingMovie()
                } else if (typeMovie == "Popular Movies") {
                    viewModel.getListPopularMovie()
                }
                return true
            }
        })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null && query.length >= 3) {
                    binding.listMovies.scrollToPosition(0)
                    adapter.filter.filter(query)
                    searchView.clearFocus()
                } else
                    snackBar("Type at least 3 characters to search")
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return true
            }

        })

        return true
    }

    override fun onFilterResult() {

    }
}