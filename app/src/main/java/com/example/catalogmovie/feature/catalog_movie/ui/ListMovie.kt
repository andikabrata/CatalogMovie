package com.example.catalogmovie.feature.catalog_movie.ui

import android.os.Bundle
import com.example.catalogmovie.common.extension.*
import com.example.catalogmovie.core.base.BaseVMActivity
import com.example.catalogmovie.databinding.ActivityListMovieBinding
import com.example.catalogmovie.feature.catalog_movie.adapter.MovieAdapter
import com.example.catalogmovie.feature.catalog_movie.di.ListMovieViewModel

class ListMovie : BaseVMActivity<ListMovieViewModel, ActivityListMovieBinding>() {

    private var toolbarValue: String = ""
    private var typeMovie: String = ""

    val adapter by lazy {
        MovieAdapter() {
            snackBar("COMING SOON")
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

        if(typeMovie == "Top Rated Movies"){
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
}