package leviata.ceos.login.register

import android.databinding.DataBindingUtil
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import leviata.ceos.R
import leviata.ceos.databinding.ActivityForgotPasswordBinding
import leviata.ceos.util.Look

class ForgotPasswordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = DataBindingUtil.setContentView<ActivityForgotPasswordBinding>(this, R.layout.activity_forgot_password)
        binding.look = Look()

        setImageLogo(getDrawable(R.drawable.ceos), binding.logo)
        binding.logo.visibility = View.VISIBLE // caso seja necessario, colocar no xml como visibl


    }

    fun setImageLogo(d: Drawable, i: ImageView) {
        Glide.with(this)
                .load(d)
                .into(i)
    }
}