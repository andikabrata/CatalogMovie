package com.example.catalogmovie.feature.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class SectionsPagerAdapter(fm: FragmentManager?) :
    FragmentPagerAdapter(fm!!) {
    var fragments: MutableList<Fragment> = ArrayList()
    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return fragments[position]
    }

    override fun getCount(): Int {
        return fragments.size
    }
}
