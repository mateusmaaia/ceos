package leviata.ceos

import android.content.Intent
import android.databinding.DataBindingUtil
import android.graphics.drawable.Drawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import leviata.ceos.databinding.ActivityMainBinding
import leviata.ceos.login.register.ForgotPasswordActivity
import leviata.ceos.login.register.RegisterActivity
import leviata.ceos.navigation.NavigationActivity
import leviata.ceos.util.Look
import leviata.ceos.util.startAnimation

class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.look = Look()
        val handler = Handler()

        setImageLogo(getDrawable(R.drawable.ceos), binding.logo)
        binding.logo.visibility = View.VISIBLE // caso seja necessario, colocar no xml como visibl

        binding.btnLogin.setOnClickListener {
            count++

            val username = binding.username.text.toString().toLowerCase()
            val password = binding.password.text.toString().toLowerCase()

            if(username == "daniel.samsung" && password == "123456"){
                startActivity(Intent(this, NavigationActivity::class.java))
            } else {
                Toast.makeText(this, "Senha ou usuário incorretos!", Toast.LENGTH_SHORT).show()
            }

        }


        binding.registerlink.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.forgotPassword.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }

    }

    fun setImageLogo(d: Drawable, i: ImageView) {
        Glide.with(this)
                .load(d)
                .into(i)
    }

    override fun onResume() {
        super.onResume()
        count = 0
    }

}

