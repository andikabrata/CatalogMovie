package com.example.catalogmovie.feature.catalog_tv.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.example.catalogmovie.R
import com.example.catalogmovie.common.extension.gridLayoutManager
import com.example.catalogmovie.common.extension.snackBar
import com.example.catalogmovie.feature.catalog_tv.adapter.MenuTvAdapter
import com.example.catalogmovie.model.menu.MenuProject
import com.example.catalogmovie.model.tv.DataMenuTvExt

class TvFragment : Fragment(), OnItemClickListener {

    private var listMenu: RecyclerView? = null

    val mAdapter by lazy {
        MenuTvAdapter()
    }

    fun TvFragment() {
        // Required empty public constructor
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(
            R.layout.fragment_tv, container, false
        )
    }

    @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mAdapter.apply {
            removeAllHeaderView()
            setNewInstance(DataMenuTvExt.fetchDataMenu(this@TvFragment))
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
            getString(R.string.popular_tv_shows) -> {
                val intent = Intent(context, ListTv::class.java)
                intent.putExtra("toolbar", "Popular TV shows")
                intent.putExtra("typeTv", "Popular TV shows")
                startActivity(intent)
            }

            getString(R.string.top_rated_tv_shows) -> {
                val intent = Intent(context, ListTv::class.java)
                intent.putExtra("toolbar", "Top rated TV shows")
                intent.putExtra("typeTv", "Top rated TV shows")
                startActivity(intent)
            }

            getString(R.string.on_air_tv_shows) -> {
                val intent = Intent(context, ListTv::class.java)
                intent.putExtra("toolbar", "On the air TV shows")
                intent.putExtra("typeTv", "On the air TV shows")
                startActivity(intent)
            }

            getString(R.string.airing_today_tv_shows) -> {
                val intent = Intent(context, ListTv::class.java)
                intent.putExtra("toolbar", "Airing today TV shows")
                intent.putExtra("typeTv", "Airing today TV shows")
                startActivity(intent)
            }
        }
    }
}