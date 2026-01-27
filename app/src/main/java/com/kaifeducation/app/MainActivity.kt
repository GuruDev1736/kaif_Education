package com.kaifeducation.app

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.browser.customtabs.CustomTabsIntent

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Launch TWA for the Kaif Education Foundation website
        val twaUrl = Uri.parse("https://kaifeducationfoundation.org/")

        try {
            // Build Custom Tabs Intent with TWA configuration
            val builder = CustomTabsIntent.Builder()

            // Configure for TWA experience
            builder.setShowTitle(false) // Hide title bar for app-like experience
            builder.setShareState(CustomTabsIntent.SHARE_STATE_OFF) // Disable share button
            builder.setUrlBarHidingEnabled(true) // Hide URL bar

            // Build and launch
            val customTabsIntent = builder.build()

            // Launch as TWA
            customTabsIntent.launchUrl(this, twaUrl)
        } catch (e: Exception) {
            e.printStackTrace()
        }

        // Finish this activity so user doesn't return to it
        finish()
    }
}

