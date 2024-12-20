package com.example.tmezek

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tmezek.fragments.LoginFragment

class ScreenSplash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_screen_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val isLoggedIn = getSharedPreferences("app_prefs", MODE_PRIVATE)
                .getBoolean("isLoggedIn", false)

            val nextActivity = if (isLoggedIn) MainActivity::class.java else LoginPage::class.java
            startActivity(Intent(this, nextActivity))
            finish()
        }, 2500)

    }
}