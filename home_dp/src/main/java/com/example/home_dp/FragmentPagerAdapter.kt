package com.example.home_dp

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.home_dp.Bookmark.BookmarkTab
import com.example.home_dp.MyRef.RefTab

class FragmentPagerAdapter(activity: RefMainActivity): FragmentStateAdapter(activity){
    val fragments: List<Fragment> = listOf(RefTab(), BookmarkTab())

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return fragments[0]
            1 -> return fragments[1]
        }
        return fragments[0]
    }
    override fun getItemCount(): Int = fragments.size
}