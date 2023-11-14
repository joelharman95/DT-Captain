/*
 * Created by Nethaji V on 31/01/22, 3:19 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 3:19 PM
 */

package com.thalappakatti.captain.ui.unsuccessfulorder

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.thalappakatti.captain.data.viewmodel.SlideshowViewModel
import com.thalappakatti.captain.databinding.FragmentUnsuccessfulOrderBinding
import com.thalappakatti.captain.ui.splash.SplashFragmentDirections
import org.koin.androidx.viewmodel.ext.android.viewModel

class UnsuccessfulOrderFragment : Fragment() {

    private val viewModel by viewModel<SlideshowViewModel>()
    private var _binding: FragmentUnsuccessfulOrderBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentUnsuccessfulOrderBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textSlideshow
        binding.textSlideshow.setOnClickListener {
            val action = UnsuccessfulOrderFragmentDirections.actionUnSuccessFragmentToCheckoutFragment()
            findNavController().navigate(action)
        }
        viewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}