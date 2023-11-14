/*
 * Created by Nethaji V on 31/01/22, 8:43 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 8:43 PM
 */

package com.thalappakatti.captain.ui.connexion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.thalappakatti.captain.R
import com.thalappakatti.captain.data.viewmodel.LoginViewModel
import com.thalappakatti.captain.data.viewmodel.StoreSelectionViewModel
import com.thalappakatti.captain.databinding.FragmentLoginBinding
import com.thalappakatti.captain.databinding.FragmentStoreSelectionBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class StoreSelectionBottomSheetFragment : BottomSheetDialogFragment() {

    private val viewModel by viewModel<StoreSelectionViewModel>()
    private var _binding: FragmentStoreSelectionBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStoreSelectionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.BottomSheetMenuTheme
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigateToHome.observe(this, {
            navigateToHome()
        })
    }

    private fun navigateToHome() {
        val action = StoreSelectionBottomSheetFragmentDirections.actionStoreSelectionFragmentToFragmentOrderNow()
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnClose.setOnClickListener {
//            dismiss()
            navigateToHome()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}