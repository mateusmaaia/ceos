package leviata.ceos

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.bumptech.glide.Glide
import leviata.ceos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.look = Look()
        val handler = Handler()

        Glide.with(this)
                .load(R.drawable.mind)
                .into(binding.logo)

        binding.btnLogin.setOnClickListener {
            binding.logo.visibility = View.VISIBLE
            binding.logo.startAnimation(R.anim.fade_in) {
                handler.postDelayed({
                    binding.logo.visibility = View.INVISIBLE
                }, 2000)

            }
        }
    }
}
