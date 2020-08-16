package com.luminarlab.consent.internal

import com.google.android.ump.ConsentRequestParameters
import com.luminarlab.consent.dsl.ConsentOptions

internal fun ConsentOptions.toParams(): ConsentRequestParameters = ConsentRequestParameters.Builder().apply {
    tagForUnderageOfConsent?.let { this.setTagForUnderAgeOfConsent(it) }
    consentDebugSettings?.let { this.setConsentDebugSettings(it) }
    admobId?.let { this.setAdMobAppId(it) }
}.build()