package com.luminarlab.consent.extensions

import android.app.Activity
import com.google.android.ump.ConsentForm

fun ConsentForm.show(activity: Activity) = show(activity) {
    throw kotlin.Exception("Couldn't show dialog: ${it?.message}")
}