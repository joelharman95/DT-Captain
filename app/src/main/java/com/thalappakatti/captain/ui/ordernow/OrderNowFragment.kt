/*
 * Created by Nethaji V on 31/01/22, 3:19 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 3:19 PM
 */

package com.thalappakatti.captain.ui.ordernow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import com.thalappakatti.captain.R
import com.thalappakatti.captain.data.viewmodel.HomeViewModel
import com.thalappakatti.captain.databinding.FragmentOrderNowBinding
import com.thalappakatti.captain.ui.ordernow.adapter.OrderNowViewPager
import com.thalappakatti.captain.ui.ordernow.innerview.TableFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class OrderNowFragment : Fragment() {

    private val viewModel by viewModel<HomeViewModel>()
    private var _binding: FragmentOrderNowBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderNowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val customerViewPager = OrderNowViewPager(childFragmentManager, lifecycle)
        customerViewPager.addViews(TableFragment("All"), getString(R.string.label_login))
        customerViewPager.addViews(TableFragment("Running"), getString(R.string.label_running_table))
        customerViewPager.addViews(TableFragment("Empty"), getString(R.string.label_empty))

        binding.vpOrderNow.offscreenPageLimit = 3
        binding.vpOrderNow.adapter = customerViewPager
        val tabTitle = listOf(
            getString(R.string.label_all),
            getString(R.string.label_running_table),
            getString(R.string.label_empty)
        )
        TabLayoutMediator(binding.tlOrderNow, binding.vpOrderNow) { tab, position ->
            tab.text = tabTitle[position]
        }.attach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}