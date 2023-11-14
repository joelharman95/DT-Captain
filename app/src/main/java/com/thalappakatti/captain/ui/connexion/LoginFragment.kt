/*
 * Created by Nethaji V on 31/01/22, 5:18 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 5:18 PM
 */

package com.thalappakatti.captain.ui.connexion

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.thalappakatti.captain.R
import com.thalappakatti.captain.data.viewmodel.LoginViewModel
import com.thalappakatti.captain.databinding.FragmentLoginBinding
import com.thalappakatti.captain.di.loadImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel by viewModel<LoginViewModel>()
    private var _binding: FragmentLoginBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel.navigateToStoreSelection.observe(this, {
            navigateToStoreSelection()
        })
        viewModel.errorEmail.observe(this, {
            when(it) {
                0 -> {
                    binding.etEmail.error = getString(R.string.empty_username)
                    binding.etEmail.requestFocus()
                }
            }
        })
        viewModel.errorPassword.observe(this, {
            binding.etPassword.error = getString(R.string.empty_password)
            binding.etPassword.requestFocus()
        })
    }

    private fun navigateToStoreSelection() {
        val action = LoginFragmentDirections.actionLoginFragmentToFragmentOrderNow()
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            viewModel.performLogin(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            )
        }

        binding.ivLogo.loadImage(R.drawable.thalappakatti_logo)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}