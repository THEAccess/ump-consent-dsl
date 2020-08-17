package com.luminarlab.consent.dsl

import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

fun showConsentForm(
    activity: ComponentActivity,
    optionsBuilder: (ConsentOptions.() -> Unit)? = null
) = activity.lifecycleScope.launchWhenCreated {
    withContext(Dispatchers.Main) {
        createConsentDelegate(activity, optionsBuilder).showIfRequired()
    }
}