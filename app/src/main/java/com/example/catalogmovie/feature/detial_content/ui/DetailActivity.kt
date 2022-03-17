package com.example.catalogmovie.feature.detial_content.ui

import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import com.example.catalogmovie.common.extension.loadImageCard
import com.example.catalogmovie.common.extension.orEmpty
import com.example.catalogmovie.core.base.BaseActivity
import com.example.catalogmovie.core.di.IMAGE_SOURCE
import com.example.catalogmovie.databinding.ActivityDetailBinding


class DetailActivity : BaseActivity<ActivityDetailBinding>() {
    private var title: String = ""
    private var date: String = ""
    private var overview: String = ""
    private var imagePath: String = ""
    private var voteAverage: String = ""

    override fun getViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {

        title = intent.getStringExtra("title").orEmpty()
        date = intent.getStringExtra("date").orEmpty()
        overview = intent.getStringExtra("overview").orEmpty()
        imagePath = intent.getStringExtra("image_path").orEmpty()
        voteAverage = intent.getStringExtra("vote_average").orEmpty()

        setSupportActionBar(binding.toolbar)
        supportActionBar!!.title = title
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.title.text = title
        binding.date.text = date
        binding.overview.text = overview
        binding.posterPath.loadImageCard(IMAGE_SOURCE + imagePath)
        binding.propertyInterest.rating = voteAverage.toFloat()
        binding.propertyInterest.setIsIndicator(true)

    }
}