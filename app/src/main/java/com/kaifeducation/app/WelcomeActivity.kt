package com.kaifeducation.app

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.card.MaterialCardView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // Get views
        val btnLetsGo = findViewById<MaterialButton>(R.id.btnLetsGo)
        val contentCard = findViewById<MaterialCardView>(R.id.contentCard)
        val educationIcon = findViewById<View>(R.id.educationIcon)
        val welcomeTitle = findViewById<View>(R.id.welcomeTitle)
        val decorativeLine = findViewById<View>(R.id.decorativeLine)
        val welcomeMessage = findViewById<View>(R.id.welcomeMessage)
        val featuresLayout = findViewById<View>(R.id.featuresLayout)
        val bottomTagline = findViewById<View>(R.id.bottomTagline)

        // Load animations
        val fadeInScale = AnimationUtils.loadAnimation(this, R.anim.fade_in_scale)

        // Animate content card
        contentCard.startAnimation(fadeInScale)

        // Animate elements with delays
        educationIcon.alpha = 0f
        educationIcon.animate()
            .alpha(1f)
            .setDuration(600)
            .setStartDelay(300)
            .start()

        welcomeTitle.alpha = 0f
        welcomeTitle.translationY = 20f
        welcomeTitle.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(600)
            .setStartDelay(400)
            .start()

        decorativeLine.alpha = 0f
        decorativeLine.scaleX = 0f
        decorativeLine.animate()
            .alpha(1f)
            .scaleX(1f)
            .setDuration(600)
            .setStartDelay(500)
            .start()

        welcomeMessage.alpha = 0f
        welcomeMessage.translationY = 20f
        welcomeMessage.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(600)
            .setStartDelay(600)
            .start()

        featuresLayout.alpha = 0f
        featuresLayout.translationY = 20f
        featuresLayout.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(600)
            .setStartDelay(700)
            .start()

        btnLetsGo.alpha = 0f
        btnLetsGo.translationY = 20f
        btnLetsGo.animate()
            .alpha(1f)
            .translationY(0f)
            .setDuration(600)
            .setStartDelay(800)
            .start()

        bottomTagline.alpha = 0f
        bottomTagline.animate()
            .alpha(0.7f)
            .setDuration(600)
            .setStartDelay(900)
            .start()

        // Button click with animation
        btnLetsGo.setOnClickListener {
            // Scale animation on click
            it.animate()
                .scaleX(0.95f)
                .scaleY(0.95f)
                .setDuration(100)
                .withEndAction {
                    it.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(100)
                        .withEndAction {
                            // Launch TWA Activity with fade out
                            contentCard.animate()
                                .alpha(0f)
                                .scaleX(0.9f)
                                .scaleY(0.9f)
                                .setDuration(300)
                                .withEndAction {
                                    val intent = Intent(this, MainActivity::class.java)
                                    startActivity(intent)
                                    finish()
                                    // Add transition animation
                                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                                }
                                .start()
                        }
                        .start()
                }
                .start()
        }
    }
}
