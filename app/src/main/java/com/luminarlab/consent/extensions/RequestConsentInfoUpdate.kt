package com.luminarlab.consent.extensions

import android.app.Activity
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters
import com.luminarlab.consent.internal.toException
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun ConsentInformation.requestConsentInfoUpdate(
    activity: Activity,
    params: ConsentRequestParameters
) = suspendCoroutine<Unit> { continuation ->
    requestConsentInfoUpdate(activity, params, {
        continuation.resume(Unit)
    }, {
        continuation.resumeWithException(it.toException())
    })
}