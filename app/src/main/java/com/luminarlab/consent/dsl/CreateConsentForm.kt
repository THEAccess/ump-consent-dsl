package com.luminarlab.consent.dsl

import androidx.activity.ComponentActivity
import com.luminarlab.consent.UmpConsentDelegate

/**
 * Von Yannick Knoll am 2020-08-16 erstellt.
 */

fun createConsentDelegate(
    activity: ComponentActivity,
    optionsBuilder: (ConsentOptions.() -> Unit)? = null
): UmpConsentDelegate {
    val options = ConsentOptions()
    optionsBuilder?.invoke(options)
    return UmpConsentDelegate(activity, options)
}

