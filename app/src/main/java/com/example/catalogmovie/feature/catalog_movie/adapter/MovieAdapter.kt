package com.example.catalogmovie.feature.catalog_movie.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogmovie.common.extension.loadImage
import com.example.catalogmovie.core.di.IMAGE_SOURCE
import com.example.catalogmovie.databinding.ItemListMovieBinding
import com.example.catalogmovie.model.movie.Movie

class MovieAdapter(
    val onItemClicked: (Movie) -> Unit
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    var list: ArrayList<Movie> = ArrayList()
    var listFiltered: ArrayList<Movie> = ArrayList()

    fun addData(list: List<Movie>) {
        this.list = list as ArrayList<Movie>
        listFiltered = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListMovieBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount() = listFiltered.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(listFiltered[position]) {
                binding.title.text = title
                binding.releaseDate.text = release_date
                binding.overview.text = overview
                binding.posterPath.loadImage(IMAGE_SOURCE + poster_path)
                binding.itemLayout.setOnClickListener {
                    onItemClicked(this)
                }
            }
        }
    }

    inner class ViewHolder(val binding: ItemListMovieBinding) : RecyclerView.ViewHolder(binding.root)

//    override fun getFilter(): Filter {
//        return object : Filter() {
//            override fun performFiltering(constraint: CharSequence?): FilterResults {
//                val charString = constraint?.toString() ?: ""
//                listFiltered = if (charString.isEmpty()) list else {
//                    val filteredList = ArrayList<Movie>()
//                    list.filter {
//                        it.name!!.lowercase().startsWith(constraint!!)
//                    }.forEach { filteredList.add(it) }
//                    filteredList
//                }
//                return FilterResults().apply { values = listFiltered }
//            }
//
//            @SuppressLint("NotifyDataSetChanged")
//            override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
//                listFiltered = if (results?.values == null)
//                    ArrayList()
//                else
//                    results.values as ArrayList<Movie>
//                notifyDataSetChanged()
//            }
//        }
//    }
}