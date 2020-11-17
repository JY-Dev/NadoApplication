package com.jydev.nadoapplication.util

import android.text.method.PasswordTransformationMethod
import android.view.View

class CustomPasswordTransformationMethod : PasswordTransformationMethod() {
    override fun getTransformation(source: CharSequence, view: View?): CharSequence {
        return CustomCharSequence(source)
    }
}