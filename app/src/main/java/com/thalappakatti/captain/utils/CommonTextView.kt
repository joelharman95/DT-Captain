/*
 * Created by Nethaji V on 31/01/22, 4:36 PM
 * Copyright (c) reserved here at Joel
 * Last modified by Nethaji V on 31/01/22, 4:36 PM
 */

package com.thalappakatti.captain.utils

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView

@SuppressLint("AppCompatCustomView")
class CommonTextView : AppCompatTextView {
    constructor(
        context: Context,
        attrs: AttributeSet?,
        defStyle: Int
    ) : super(context, attrs, defStyle) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet?) : super(
        context,
        attrs
    ) {
        init()
    }

    constructor(context: Context) : super(context) {
        init()
    }

    private fun init() {
        if (!isInEditMode) {
            /*val tf = Typeface.createFromAsset(context.assets, "googlesansregular.ttf")
            typeface = tf*/
        }
    }
}