package org.tensorflow.lite.examples.posenet

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class SampleBootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == "android.intent.action.BOOT_COMPLETED") {
            // Set the alarm here.

        }
    }
}