/*
 * Created by Nethaji V on 31/01/22, 4:35 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:35 PM
 */

package com.thalappakatti.captain.di

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.view.View
import android.view.WindowManager
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import com.thalappakatti.captain.R
import com.thalappakatti.captain.data.network.api.response.ResError
import com.thalappakatti.captain.utils.CrossFadeDrawable

fun View.getCompatColor(@ColorRes colorRes: Int): Int =
    ContextCompat.getColor(this.context, colorRes)

infix fun Context.toast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun errorResponseMessage(resError: ResError) = resError.message.toString()

val options: RequestOptions = RequestOptions().format(DecodeFormat.PREFER_RGB_565)

fun ImageView.loadImage(image: Any) {
    Glide.with(context)
        .load(
            when (image) {
                is Int -> ContextCompat.getDrawable(context, image)
                is Bitmap -> image
                else -> image
            }
        )
        .placeholder(ContextCompat.getDrawable(context, R.drawable.ic_launcher_foreground))
//        .circleCrop()
//        .apply(options)
        .transition(DrawableTransitionOptions.with(CrossFadeDrawable()))
        .into(this)
}

fun Activity.showAlert(title: String, message: String) {
    val exitDialog = androidx.appcompat.app.AlertDialog.Builder(this)
    exitDialog.setTitle(title)
    exitDialog.setMessage(message)
    exitDialog.setPositiveButton(
        "OK"
    ) { dialog, which ->
        dialog.dismiss()
        dialog.cancel()
        finish()
    }
    exitDialog.show()
}

fun Activity.blockInput(progressBar: ProgressBar?) {
    progressBar?.visibility = View.VISIBLE
    window.setFlags(
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
        WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
    )
}

infix fun Activity.unblockInput(progressBar: ProgressBar?) {
    progressBar?.visibility = View.GONE
    window.clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)
}

fun String.isSuccess(): Boolean = this == "1"

fun String.isFailure(): Boolean = this == "failure"