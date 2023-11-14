/*
 * Created by Nethaji V on 01/02/22, 4:54 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 01/02/22, 4:54 PM
 */

package com.thalappakatti.captain.ui.ordernow.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import java.util.ArrayList

class OrderNowViewPager(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getItemCount() = fragments.size

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addViews(_customerFragment: Fragment?, _customerFragmentTitle: String?) {
        fragments.add(_customerFragment!!)
        titles.add(_customerFragmentTitle!!)
    }

}