package com.thalappakatti.captain.ui.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.thalappakatti.captain.R
import com.thalappakatti.captain.databinding.FragmentSuccessBinding

class SuccessFragment : Fragment() {
    private var _binding:FragmentSuccessBinding ?=null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding= FragmentSuccessBinding.inflate(inflater,container,false)
        val root: View =binding.root
        return  root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}