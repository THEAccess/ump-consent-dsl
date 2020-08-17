package com.luminarlab.consent

import android.app.Activity
import com.google.android.ump.*
import com.luminarlab.consent.dsl.ConsentOptions
import com.luminarlab.consent.extensions.loadConsentForm
import com.luminarlab.consent.extensions.requestConsentInfoUpdate
import com.luminarlab.consent.extensions.show
import com.luminarlab.consent.internal.toParams
import kotlinx.coroutines.*

class UmpConsentDelegate internal constructor(
    private val activity: Activity,
    private val options: ConsentOptions = ConsentOptions()
) {

    private val consentInfo = GlobalScope.async {
        UserMessagingPlatform.getConsentInformation(activity).apply {
            requestConsentInfoUpdate(activity, options.toParams())
        }
    }
    private val consentForm: Deferred<ConsentForm?> =
        GlobalScope.async(Dispatchers.Main) {
            if (consentInfo.await().isConsentFormAvailable) loadConsentForm(
                activity
            ) else null
        }


    suspend fun showIfRequired()  {

        options.intercept.invoke(consentInfo.await())

        if (options.showCondition(consentInfo.await())) {
            consentForm.await()?.show(activity)
        }
    }


}


