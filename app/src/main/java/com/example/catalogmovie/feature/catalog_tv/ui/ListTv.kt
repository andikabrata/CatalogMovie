package com.example.catalogmovie.feature.catalog_tv.ui

import android.os.Bundle
import com.example.catalogmovie.common.extension.*
import com.example.catalogmovie.core.base.BaseVMActivity
import com.example.catalogmovie.databinding.ActivityListTvBinding
import com.example.catalogmovie.feature.catalog_tv.adapter.TvAdapter
import com.example.catalogmovie.feature.catalog_tv.di.ListTvViewModel
import com.example.catalogmovie.feature.detial_content.ui.DetailActivity

class ListTv : BaseVMActivity<ListTvViewModel, ActivityListTvBinding>() {
    private var toolbarValue: String = ""
    private var typeTv: String = ""

    val adapter by lazy {
        TvAdapter() {
            startActivity<DetailActivity> {
                putExtra("title",it.name)
                putExtra("date",it.first_air_date)
                putExtra("overview",it.overview)
                putExtra("image_path",it.poster_path)
            }
        }
    }

    override fun getViewModel() = ListTvViewModel::class.java

    override fun getViewBinding(): ActivityListTvBinding {
        return ActivityListTvBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        toolbarValue = intent.getStringExtra("toolbar").orEmpty()
        typeTv = intent.getStringExtra("typeTv").orEmpty()

        initToolbar(binding.toolbar, toolbarValue, back = true)

        if(typeTv == "Popular TV shows"){
            viewModel.getListPopularTv()
        } else if(typeTv == "Top rated TV shows"){
            viewModel.getListTopRatedTv()
        } else if(typeTv == "On the air TV shows"){
            viewModel.getListOnAirTv()
        } else if(typeTv == "Airing today TV shows"){
            viewModel.getListAiringTv()
        }

        binding.listTv.apply {
            gridLayoutManager(1)
        }
    }

    override fun observerViewModel() {
        viewModel.listPopularTvLiveData.onResult { state ->
            when (state) {
                is ViewState.Loading -> {
                    binding.stateLayout.toLoading()
                }

                is ViewState.Success -> {
                    if (state.data.results?.isNotEmpty().orFalse()) {
                        binding.stateLayout.toContent()
                        state.data.results?.let { adapter.addData(it) }
                        binding.listTv.adapter = adapter
                    } else
                        binding.stateLayout.toEmpty()
                }

                is ViewState.Failed -> {

                }
            }
        }

        viewModel.listTopRatedTvLiveData.onResult { state ->
            when (state) {
                is ViewState.Loading -> {
                    binding.stateLayout.toLoading()
                }

                is ViewState.Success -> {
                    if (state.data.results?.isNotEmpty().orFalse()) {
                        binding.stateLayout.toContent()
                        state.data.results?.let { adapter.addData(it) }
                        binding.listTv.adapter = adapter
                    } else
                        binding.stateLayout.toEmpty()
                }

                is ViewState.Failed -> {

                }
            }
        }

        viewModel.listOnAirTvLiveData.onResult { state ->
            when (state) {
                is ViewState.Loading -> {
                    binding.stateLayout.toLoading()
                }

                is ViewState.Success -> {
                    if (state.data.results?.isNotEmpty().orFalse()) {
                        binding.stateLayout.toContent()
                        state.data.results?.let { adapter.addData(it) }
                        binding.listTv.adapter = adapter
                    } else
                        binding.stateLayout.toEmpty()
                }

                is ViewState.Failed -> {

                }
            }
        }

        viewModel.listAiringTvLiveData.onResult { state ->
            when (state) {
                is ViewState.Loading -> {
                    binding.stateLayout.toLoading()
                }

                is ViewState.Success -> {
                    if (state.data.results?.isNotEmpty().orFalse()) {
                        binding.stateLayout.toContent()
                        state.data.results?.let { adapter.addData(it) }
                        binding.listTv.adapter = adapter
                    } else
                        binding.stateLayout.toEmpty()
                }

                is ViewState.Failed -> {

                }
            }
        }
    }
}