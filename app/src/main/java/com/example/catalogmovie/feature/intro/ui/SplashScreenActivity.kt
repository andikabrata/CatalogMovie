package com.example.catalogmovie.feature.intro.ui

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import com.example.catalogmovie.core.base.BaseActivity
import com.example.catalogmovie.databinding.ActivitySplashScreenBinding
import com.example.catalogmovie.feature.main.ui.MainActivity

class SplashScreenActivity : BaseActivity<ActivitySplashScreenBinding>() {

    override fun getViewBinding(): ActivitySplashScreenBinding {
        return ActivitySplashScreenBinding.inflate(layoutInflater)
    }

    override fun onViewCreated(savedInstanceState: Bundle?) {
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }
}