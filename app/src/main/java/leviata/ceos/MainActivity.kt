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
class MainActivity : AppCompatActivity() {

    var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.look = Look()
        val handler = Handler()

        setImageLogo(getDrawable(R.drawable.androidlogo), binding.logo)
        binding.logo.visibility = View.VISIBLE // caso seja necessario, colocar no xml como visibl

        binding.btnLogin.setOnClickListener {
            count++

            if (count == 13) {
                setImageLogo(getDrawable(R.drawable.mind), binding.logo)
                Toast.makeText(this, "SHAZAM", Toast.LENGTH_LONG).show()
                binding.logo.visibility = View.VISIBLE
                count = 0
                binding.logo.startAnimation(R.anim.fade_in) {
                    handler.postDelayed({
                        binding.logo.visibility = View.INVISIBLE
                        setImageLogo(getDrawable(R.drawable.androidlogo), binding.logo)
                        binding.logo.visibility = View.VISIBLE // caso seja necessario, colocar no xml como visibl
                    }, 2000)

                }

            }

        }

        binding.registerlink.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
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

