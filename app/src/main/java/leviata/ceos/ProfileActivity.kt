package leviata.ceos

import android.databinding.DataBindingUtil
import android.os.Bundle
import leviata.ceos.databinding.ActivityProfileBinding

class ProfileActivity : MenuFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityProfileBinding>(this, R.layout.activity_profile)
        binding.look = Look()
    }
}