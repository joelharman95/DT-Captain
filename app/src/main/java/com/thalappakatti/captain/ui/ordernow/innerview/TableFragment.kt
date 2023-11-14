/*
 * Created by Nethaji V on 01/02/22, 4:58 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 01/02/22, 4:58 PM
 */

package com.thalappakatti.captain.ui.ordernow.innerview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.thalappakatti.captain.data.viewmodel.HomeViewModel
import com.thalappakatti.captain.databinding.FragmentTableBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class TableFragment(val s: String) : Fragment() {

    private val viewModel by viewModel<HomeViewModel>()
    private var _binding: FragmentTableBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textGallery.text = s;

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}