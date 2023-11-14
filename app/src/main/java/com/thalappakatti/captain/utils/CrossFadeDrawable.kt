/*
 * Created by Nethaji V on 31/01/22, 4:36 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:36 PM
 */

package com.thalappakatti.captain.utils

import android.graphics.drawable.Drawable
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.request.transition.DrawableCrossFadeTransition
import com.bumptech.glide.request.transition.Transition
import com.bumptech.glide.request.transition.TransitionFactory

class CrossFadeDrawable : TransitionFactory<Drawable> {
    private val resourceTransition: DrawableCrossFadeTransition =
        DrawableCrossFadeTransition(300, true)

    override fun build(dataSource: DataSource?, isFirstResource: Boolean): Transition<Drawable> =
        resourceTransition
}