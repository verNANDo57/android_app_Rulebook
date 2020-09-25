package com.verNANDo57.rulebook_educational.customlocaleengine

import android.content.ComponentCallbacks
import android.content.res.Configuration

internal class CustomLocaleEngineApplicationCallbacks(private val callback: (Configuration) -> Unit) : ComponentCallbacks {

    override fun onConfigurationChanged(newConfig: Configuration) {
        callback.invoke(newConfig)
    }

    override fun onLowMemory() {
        // no-op
    }
}
