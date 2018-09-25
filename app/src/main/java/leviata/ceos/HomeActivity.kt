package leviata.ceos

import android.databinding.DataBindingUtil
import android.os.Bundle
import leviata.ceos.databinding.ActivityHomeBinding


class HomeActivity : MenuFragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        binding.look = Look()
    }


}