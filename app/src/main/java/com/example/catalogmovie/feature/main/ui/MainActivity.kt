package com.example.catalogmovie.feature.main.ui

import android.os.Bundle
import com.example.catalogmovie.core.base.BaseActivity
import com.example.catalogmovie.databinding.ActivityMainBinding
import com.example.catalogmovie.feature.catalog_movie.ui.MovieFragment
import com.example.catalogmovie.feature.catalog_tv.ui.TvFragment
import com.example.catalogmovie.feature.main.adapter.SectionsPagerAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        val mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)
        mSectionsPagerAdapter.addFragment(MovieFragment())
        mSectionsPagerAdapter.addFragment(TvFragment())

        binding.container.adapter = mSectionsPagerAdapter

        binding.container.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.tabs))
        binding.tabs.addOnTabSelectedListener(TabLayout.ViewPagerOnTabSelectedListener(binding.container))

    }
}