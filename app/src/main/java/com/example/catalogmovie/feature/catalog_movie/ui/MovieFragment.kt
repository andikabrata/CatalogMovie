package com.example.catalogmovie.feature.catalog_movie.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.example.catalogmovie.R
import com.example.catalogmovie.common.extension.gridLayoutManager
import com.example.catalogmovie.feature.catalog_movie.adapter.MenuAdapter
import com.example.catalogmovie.model.movie.DataMenuExt
import com.example.catalogmovie.model.movie.MenuProject


class MovieFragment : Fragment(), OnItemClickListener {

    private var listMenu: RecyclerView? = null

    val mAdapter by lazy {
        MenuAdapter()
    }

    fun MovieFragment() {
        // Required empty public constructor
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_movie, container, false
        )
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter.apply {
            removeAllHeaderView()
            setNewInstance(DataMenuExt.fetchDataMenu(this@MovieFragment))
        }

        listMenu = view.findViewById(R.id.list_menu)

        listMenu?.apply {
            gridLayoutManager(1)
            adapter = mAdapter
        }

        mAdapter.setOnItemClickListener(this)
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        val item = adapter.data[position] as MenuProject
        when (item.title) {
            getString(R.string.top_rated_movies) -> {
                val intent = Intent(context, ListMovie::class.java)
                intent.putExtra("toolbar","Top Rated Movies")
                intent.putExtra("typeMovie","Top Rated Movies")
                startActivity(intent)
            }

            getString(R.string.upcoming_movies) -> {
                val intent = Intent(context, ListMovie::class.java)
                intent.putExtra("toolbar","Upcoming Movies")
                intent.putExtra("typeMovie","Upcoming Movies")
                startActivity(intent)
            }

            getString(R.string.now_playing_movies) -> {
                val intent = Intent(context, ListMovie::class.java)
                intent.putExtra("toolbar","Now Playing Movies")
                intent.putExtra("typeMovie","Now Playing Movies")
                startActivity(intent)
            }

            getString(R.string.popular_movies) -> {
                val intent = Intent(context, ListMovie::class.java)
                intent.putExtra("toolbar","Popular Movies")
                intent.putExtra("typeMovie","Popular Movies")
                startActivity(intent)
            }
        }
    }

}