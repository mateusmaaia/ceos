package leviata.ceos

import android.databinding.DataBindingUtil
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide
import leviata.ceos.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityRegisterBinding>(this, R.layout.activity_register)
        binding.look = Look()

        setImageLogo(getDrawable(R.drawable.logo), binding.logo)
        binding.logo.visibility = View.VISIBLE // caso seja necessario, colocar no xml como visibl

    }

    fun setImageLogo(d: Drawable, i: ImageView) {
        Glide.with(this)
                .load(d)
                .into(i)
    }
}