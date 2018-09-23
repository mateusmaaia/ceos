package leviata.ceos

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import leviata.ceos.databinding.ActivityHomeBinding
import android.content.Intent
import android.support.v7.app.ActionBar
import android.view.MenuItem


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityHomeBinding>(this, R.layout.activity_home)
        binding.look = Look()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    /*- On Options Item Selected --------------------------------------------------------- */
    // One of the toolbar icons was clicked
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here.
        val id = item.getItemId()

        if (id == R.id.navigationMenu) {
            val i = Intent(this@HomeActivity, HomeActivity::class.java)
            startActivity(i)
            finish()
        }
        return super.onOptionsItemSelected(item)
    }

}