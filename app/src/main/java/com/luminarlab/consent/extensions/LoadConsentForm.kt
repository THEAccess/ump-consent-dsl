package com.luminarlab.consent.extensions

import android.app.Activity
import com.google.android.ump.ConsentForm
import com.google.android.ump.UserMessagingPlatform
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun loadConsentForm(activity: Activity) =
    suspendCoroutine<ConsentForm> { continuation ->
        UserMessagingPlatform.loadConsentForm(activity, {
            continuation.resume(it)
        }, {
            continuation.resumeWithException(it.toException())
        })
    }