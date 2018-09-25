package leviata.ceos.login.register

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import com.bumptech.glide.Glide
import leviata.ceos.MainActivity
import leviata.ceos.R
import leviata.ceos.databinding.ActivitySplashBinding
import leviata.ceos.util.Look


class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = DataBindingUtil.setContentView<ActivitySplashBinding>(this, R.layout.activity_splash)
        binding.look = Look()

        setImageLogo(getDrawable(R.drawable.logo), binding.logo)

        Handler().postDelayed({
            startActivity(Intent(this@SplashActivity, MainActivity::class.java))
            finish()
        },3000)

    }

    fun setImageLogo(d: Drawable, i: ImageView) {
        Glide.with(this)
                .load(d)
                .into(i)
    }
}