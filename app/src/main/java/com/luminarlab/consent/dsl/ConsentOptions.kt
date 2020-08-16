package com.luminarlab.consent.dsl

import android.util.Log
import com.google.android.ump.ConsentDebugSettings
import com.google.android.ump.ConsentInformation
import com.google.android.ump.ConsentRequestParameters

/**
 * Von Yannick Knoll am 2020-08-16 erstellt.
 */

@ConsentFormDSLMarker
class ConsentOptions {

    var tagForUnderageOfConsent: Boolean? = null
    var consentDebugSettings: ConsentDebugSettings? = null
    var admobId: String? = null
    var showIfCondition = { consentInfo: ConsentInformation ->
        consentInfo.consentStatus == ConsentInformation.ConsentStatus.REQUIRED || consentInfo.consentStatus == ConsentInformation.ConsentStatus.UNKNOWN
    }
    var intercept = { consentInfo: ConsentInformation ->
        Log.d(
            "Consent",
            "FormAvailable: ${consentInfo.isConsentFormAvailable} | Status: ${consentInfo.consentStatus}"
        )
    }


}


