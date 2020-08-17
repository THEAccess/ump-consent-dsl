package com.luminarlab.consent.dsl

import android.util.Log
import com.google.android.ump.ConsentDebugSettings
import com.google.android.ump.ConsentInformation

/**
 * Von Yannick Knoll am 2020-08-16 erstellt.
 */

@ConsentFormDSLMarker
class ConsentOptions {

    var tagForUnderageOfConsent: Boolean? = null
    var consentDebugSettings: ConsentDebugSettings? = null
    var admobId: String? = null
    internal var showCondition = { consentInfo: ConsentInformation ->
        consentInfo.consentStatus == ConsentInformation.ConsentStatus.REQUIRED || consentInfo.consentStatus == ConsentInformation.ConsentStatus.UNKNOWN
    }
    private set

    fun showIf(condition: (ConsentInformation) -> Boolean) {
        showCondition = condition
    }

    internal var intercept: (ConsentInformation) -> Unit = { consentInfo: ConsentInformation ->
        Log.d(
            "Consent",
            "FormAvailable: ${consentInfo.isConsentFormAvailable} | Status: ${consentInfo.consentStatus}"
        )
    }
    private set

    fun intercept(interceptor: (ConsentInformation) -> Unit) {
        intercept = interceptor
    }


}


