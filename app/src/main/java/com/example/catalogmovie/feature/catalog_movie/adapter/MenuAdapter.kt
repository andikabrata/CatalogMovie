package com.example.catalogmovie.feature.catalog_movie.adapter

import androidx.core.content.ContextCompat
import com.example.catalogmovie.core.base.BaseBindingAdapter
import com.example.catalogmovie.core.base.VBViewHolder
import com.example.catalogmovie.databinding.MenuProjectItemBinding
import com.example.catalogmovie.model.movie.MenuProject

class MenuAdapter : BaseBindingAdapter<MenuProjectItemBinding, MenuProject>() {
    override fun convert(holder: VBViewHolder<MenuProjectItemBinding>, item: MenuProject) {
        val binding: MenuProjectItemBinding = holder.vb
        binding.tvTitle.text = item.title
        binding.imgProject.background =
            ContextCompat.getDrawable(binding.imgProject.context, item.icon)
    }
}