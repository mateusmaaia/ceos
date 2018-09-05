package leviata.ceos

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import leviata.ceos.databinding.ActivityForgotPasswordBinding

class ForgotPassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityForgotPasswordBinding>(this, R.layout.activity_forgot_password)
        binding.look = Look()

    }
}