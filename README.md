# UMP Simple DSL
A DSL and Kotlin extensions for [User Messaging Platform](https://developers.google.com/admob/ump/android/quick-start) 

This library simplifies common steps when using UMP by Admob:

  - Automatically load consent information and consent form
  - Setup and show form via dsl
  - Coroutine extensions for common functions

### Quick Start

Don't forget to add `com.google.android.gms.ads.APPLICATION_ID` to your `AndroidManifest.xml`
´´´
# UMP Simple DSL
A DSL and Kotlin extensions for [User Messaging Platform](https://developers.google.com/admob/ump/android/quick-start) 

This library simplifies common steps when using UMP by Admob:

  - Automatically load consent information and consent form
  - Setup and show form via dsl
  - Coroutine extensions for common functions

### Quick Start

_Don't forget to add `com.google.android.gms.ads.APPLICATION_ID` to your `AndroidManifest.xml`_

Simple:
```
showConsentForm(this)
```

With options:
```
     showConsentForm(this) {
            tagForUnderageOfConsent = true
            admobId = "pub-ca-XXXXXXXXXX"
            showIfCondition = { consentInfo ->
                consentInfo.consentStatus == ConsentInformation.ConsentStatus.REQUIRED || consentInfo.consentStatus == ConsentInformation.ConsentStatus.UNKNOWN
            }
            intercept = {consentInfo ->
                Log.d(
                    "Consent",
                    "FormAvailable: ${consentInfo.isConsentFormAvailable} | Status:${consentInfo.consentStatus}"
                )
            }
        }
```

You can use `createConsentForm(...)` as an alias for `showConsentForm(...)` and use `#showIfRequired` later if you want to show your form later 

