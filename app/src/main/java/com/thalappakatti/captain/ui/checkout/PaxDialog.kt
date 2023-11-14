package com.thalappakatti.captain.ui.checkout

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.thalappakatti.captain.R
import com.thalappakatti.captain.databinding.DialogPaxBinding
import com.thalappakatti.captain.di.toast

class PaxDialog : DialogFragment() {
    private var _binding: DialogPaxBinding? = null
    private val binding get() = _binding!!

    override fun onStart() {
        super.onStart()
        val width = (resources.displayMetrics.widthPixels * 0.90).toInt()
        val height = (resources.displayMetrics.heightPixels * 0.90).toInt()
        dialog!!.window?.setLayout(width, ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        dialog!!.window?.setBackgroundDrawableResource(R.drawable.dialog_round_corner)
        _binding = DialogPaxBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnSave.setOnClickListener {
            vaildateFields()
        }
    }

    private fun vaildateFields() {
        when {
            TextUtils.isEmpty(binding.editName.text) -> binding.editName.error =
                getString(R.string.label_error_name)
            TextUtils.isEmpty(binding.editNumber.text) -> binding.editNumber.error =
                getString(R.string.label_error_number)
            TextUtils.isEmpty(binding.editPax.text) -> binding.editPax.error =
                getString(R.string.label_error_pax)
            else -> {
                activity?.toast("Success!")
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}