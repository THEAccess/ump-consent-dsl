package com.luminarlab.consent.extensions

import com.google.android.ump.FormError

fun FormError.toException() = Exception("FormError: $message ($errorCode)")