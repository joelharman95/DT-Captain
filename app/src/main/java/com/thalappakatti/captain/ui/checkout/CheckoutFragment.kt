package com.thalappakatti.captain.ui.checkout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.thalappakatti.captain.R
import com.thalappakatti.captain.databinding.FragmentCheckoutBinding
import com.thalappakatti.captain.databinding.FragmentUnsuccessfulOrderBinding

class CheckoutFragment : Fragment(), View.OnClickListener {
    private var _binding: FragmentCheckoutBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       _binding= FragmentCheckoutBinding.inflate(inflater,container,false)
        val root:View=binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.pax.setOnClickListener(this)
        binding.success.setOnClickListener(this)
        binding.failer.setOnClickListener(this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.pax->{
                val pax=PaxDialog()
                pax.show(childFragmentManager,"")
            }
            R.id.success->{
           val action= CheckoutFragmentDirections.actionCheckoutFragmentToSuccessFragment()
                findNavController().navigate(action)
            }
            R.id.failer->{
           val  action=CheckoutFragmentDirections.actionCheckoutFragmentToFailerFragment()
                findNavController().navigate(action)
            }
        }

    }
}