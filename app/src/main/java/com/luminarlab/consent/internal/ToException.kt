package com.luminarlab.consent.internal

import com.google.android.ump.FormError

internal fun FormError.toException() = Exception("FormError: $message ($errorCode)")