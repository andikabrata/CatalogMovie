package com.example.catalogmovie.feature.catalog_tv.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.SearchView
import com.example.catalogmovie.R
import com.example.catalogmovie.common.extension.*
import com.example.catalogmovie.core.base.BaseVMActivity
import com.example.catalogmovie.databinding.ActivityListTvBinding
import com.example.catalogmovie.feature.OnFilterDialogListener
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

        when (typeTv) {
            "Popular TV shows" -> {
                viewModel.getListPopularTv()
            }
            "Top rated TV shows" -> {
                viewModel.getListTopRatedTv()
            }
            "On the air TV shows" -> {
                viewModel.getListOnAirTv()
            }
            "Airing today TV shows" -> {
                viewModel.getListAiringTv()
            }
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
                when (typeTv) {
                    "Popular TV shows" -> {
                        viewModel.getListPopularTv()
                    }
                    "Top rated TV shows" -> {
                        viewModel.getListTopRatedTv()
                    }
                    "On the air TV shows" -> {
                        viewModel.getListOnAirTv()
                    }
                    "Airing today TV shows" -> {
                        viewModel.getListAiringTv()
                    }
                }
                return true
            }
        })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                if (query != null && query.length >= 3) {
                    binding.listTv.scrollToPosition(0)
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
}