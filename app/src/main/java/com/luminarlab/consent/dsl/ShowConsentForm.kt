package com.luminarlab.consent.dsl

import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope

fun showConsentForm(
    activity: ComponentActivity,
    optionsBuilder: (ConsentOptions.() -> Unit)? = null
) = activity.lifecycleScope.launchWhenCreated {
    createConsentDelegate(activity, optionsBuilder).showIfRequired()
}