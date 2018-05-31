package com.kamedon.simpletodo.utils.extensions

import android.content.res.Resources
import android.util.TypedValue

val Float.dp get() = TypedValue.applyDimension(android.util.TypedValue.COMPLEX_UNIT_DIP, this, Resources.getSystem().displayMetrics)
val Float.sp get() = TypedValue.applyDimension(android.util.TypedValue.COMPLEX_UNIT_SP, this, Resources.getSystem().displayMetrics)
val Int.dp get() = toFloat().dp.toInt()
val Int.sp get() = toFloat().sp.toInt()
