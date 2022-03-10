package com.example.catalogmovie.feature.catalog_tv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogmovie.common.extension.loadImage
import com.example.catalogmovie.core.di.IMAGE_SOURCE
import com.example.catalogmovie.databinding.ItemListTvBinding
import com.example.catalogmovie.model.tv.Tv

class TvAdapter(val onItemClicked: (Tv) -> Unit) :
    RecyclerView.Adapter<TvAdapter.ViewHolder>() {

    var list: ArrayList<Tv> = ArrayList()
    var listFiltered: ArrayList<Tv> = ArrayList()

    fun addData(list: List<Tv>) {
        this.list = list as ArrayList<Tv>
        listFiltered = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListTvBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = listFiltered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listFiltered[position]) {
                binding.name.text = name
                binding.firstAirDate.text = first_air_date
                binding.overview.text = overview
                binding.posterPath.loadImage(IMAGE_SOURCE + poster_path)
                binding.itemLayout.setOnClickListener {
                    onItemClicked(this)
                }
            }
        }
    }

    inner class ViewHolder(val binding: ItemListTvBinding) : RecyclerView.ViewHolder(binding.root)
}