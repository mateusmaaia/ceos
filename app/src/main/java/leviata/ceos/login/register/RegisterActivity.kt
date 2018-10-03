package leviata.ceos.login.register

import android.databinding.DataBindingUtil
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide
import leviata.ceos.R
import leviata.ceos.databinding.ActivityRegisterBinding
import leviata.ceos.util.Look

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        val binding = DataBindingUtil.setContentView<ActivityRegisterBinding>(this, R.layout.activity_register)
        binding.look = Look()
        var context = applicationContext


        binding.btnLogin.setOnClickListener {
            val username = binding.username.text.toString().isEmpty()
            val password = binding.password.text.toString().isEmpty()
            val email = binding.email.text.toString().isEmpty()

                if(!checkNotNull(username) && !checkNotNull(password) && !checkNotNull(email)) {
                    Toast.makeText(context, "Pronto! Agora é só confirmar seu e-mail.", Toast.LENGTH_SHORT).show()
                } else {
                    binding.btnLogin.setOnClickListener {
                        Toast.makeText(context, "Ops, parece que estão faltando alguns campos, não?", Toast.LENGTH_SHORT).show()
                    }
            }
        }

        setImageLogo(getDrawable(R.drawable.ceos), binding.logo)
        binding.logo.visibility = View.VISIBLE

    }

    fun setImageLogo(d: Drawable, i: ImageView) {
        Glide.with(this)
                .load(d)
                .into(i)
    }
}