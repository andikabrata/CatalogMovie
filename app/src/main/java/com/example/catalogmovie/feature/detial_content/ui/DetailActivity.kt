package com.example.catalogmovie.feature.detial_content.ui

import android.os.Bundle
import com.example.catalogmovie.R
import com.example.catalogmovie.common.extension.loadImage
import com.example.catalogmovie.common.extension.loadImageCard
import com.example.catalogmovie.common.extension.orEmpty
import com.example.catalogmovie.core.base.BaseActivity
import com.example.catalogmovie.core.base.BaseVMActivity
import com.example.catalogmovie.core.di.IMAGE_SOURCE
import com.example.catalogmovie.databinding.ActivityDetailBinding
import com.example.catalogmovie.databinding.ActivityListTvBinding
import com.example.catalogmovie.feature.catalog_tv.di.ListTvViewModel

class DetailActivity : BaseActivity<ActivityDetailBinding>() {
    private var title: String = ""
    private var date: String = ""
    private var overview: String = ""
    private var image_path: String = ""

    override fun getViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {

        title = intent.getStringExtra("title").orEmpty()
        date = intent.getStringExtra("date").orEmpty()
        overview = intent.getStringExtra("overview").orEmpty()
        image_path = intent.getStringExtra("image_path").orEmpty()

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.title = title
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.title.text = title
        binding.date.text = date
        binding.overview.text = overview
        binding.posterPath.loadImageCard(IMAGE_SOURCE + image_path)

    }
}