package com.luminarlab.consent

import android.app.Activity
import android.util.Log
import com.google.android.ump.*
import com.luminarlab.consent.extensions.loadConsentForm
import com.luminarlab.consent.extensions.requestConsentInfoUpdate
import com.luminarlab.consent.extensions.show
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UmpConsent(private val activity: Activity) {

    private val params = ConsentRequestParameters.Builder().build()
    private val consentInfo = GlobalScope.async {
        UserMessagingPlatform.getConsentInformation(activity).apply {
            requestConsentInfoUpdate(activity, params)
        }
    }
    private val consentForm: Deferred<ConsentForm?> =
        GlobalScope.async { if (consentInfo.await().isConsentFormAvailable) loadConsentForm(
            activity
        ) else null }



    suspend fun showIfRequired() = GlobalScope.launch {

        Log.d(
            "Consent",
            "FormAvailable: ${consentInfo.await().isConsentFormAvailable} | Status:${consentInfo.await().consentStatus}"
        )

        if (consentInfo.await().consentStatus == ConsentInformation.ConsentStatus.REQUIRED || consentInfo.await().consentStatus == ConsentInformation.ConsentStatus.UNKNOWN) {
            consentForm.await()?.show(activity)
        }
    }



}


