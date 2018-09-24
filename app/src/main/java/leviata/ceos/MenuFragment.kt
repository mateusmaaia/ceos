package leviata.ceos

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem


open class MenuFragment : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val selectedItem = item.itemId

        when(selectedItem){

            R.id.perfil->{
                startActivity(Intent(this, ProfileActivity::class.java))
                return true
            }

            R.id.criar_desafio->{

            }

            R.id.grupos->{

            }
            R.id.ranking_geral->{

            }
            R.id.logout->{

            }
        }

        return super.onOptionsItemSelected(item)
    }
}