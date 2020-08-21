package com.luminarlab.consent.extensions

import kotlinx.coroutines.delay
import java.lang.Exception

/**
 * Von Yannick Knoll am 2020-08-21 erstellt.
 */

internal suspend fun <T> retry(delayMillis: Long = 0, block: suspend () -> T): T = try {
    block()
} catch (e: Exception) {
    delay(delayMillis)
    retry(delayMillis, block)
}
