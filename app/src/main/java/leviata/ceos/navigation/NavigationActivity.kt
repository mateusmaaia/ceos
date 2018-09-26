package leviata.ceos.navigation

import android.content.res.TypedArray
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import leviata.ceos.R
import leviata.ceos.databinding.ActivityNavigationBinding


class NavigationActivity : AppCompatActivity() {

    lateinit var presenter: NavigationPresenter
    lateinit var binding: ActivityNavigationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityNavigationBinding>(this, R.layout.activity_navigation)

        this.binding = binding
        val presenter = NavigationPresenter(this, binding)
        this.presenter = presenter

        val ctx = applicationContext
        val res = ctx.resources
        val titles = res.getStringArray(R.array.titles)
        val icons = res.obtainTypedArray(R.array.icons)

        createMenuItems(menu = binding.leftDrawer.menu, titles = titles, icons = icons)

        lifecycle.addObserver(presenter)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.contentFragment, HomeFragment()).commit()
        }

    }

    private fun createMenuItems(menu: Menu, titles: Array<String>, icons: TypedArray) {

        for ((index, title) in titles.withIndex()) {
            when (title) {
                NavigationActivity.HOME -> inflateMenuItem(menu, title, icons.getResourceId(index, -1), NavigationActivity.HOME_ID)
                NavigationActivity.PERFIL -> inflateMenuItem(menu, title, icons.getResourceId(index, -1), NavigationActivity.PERFIL_ID)
                NavigationActivity.CRIAR_DESAFIO -> inflateMenuItem(menu, title, icons.getResourceId(index, -1), NavigationActivity.CRIAR_DESAFIO_ID)
                NavigationActivity.GRUPOS -> inflateMenuItem(menu, title, icons.getResourceId(index, -1), NavigationActivity.GRUPOS_ID)
                NavigationActivity.RANKING_GERAL -> inflateMenuItem(menu, title, icons.getResourceId(index, -1), NavigationActivity.RANKING_GERAL_ID)
                NavigationActivity.LOGOUT -> inflateMenuItem(menu, title, icons.getResourceId(index, -1), NavigationActivity.LOGOUT_ID)
            }
        }
    }

    private fun inflateMenuItem(menu: Menu, title: String, icon: Int, id: Int) {
        val menuItem = menu.add(Menu.NONE, id, 0, title)
        menuItem.icon = ContextCompat.getDrawable(this, icon)
    }

    companion object {
        const val HOME = "HOME"
        const val PERFIL = "PERFIL"
        const val CRIAR_DESAFIO = "CRIAR_DESAFIO"
        const val GRUPOS = "GRUPOS"
        const val RANKING_GERAL = "RANKING_GERAL"
        const val LOGOUT = "LOGOUT"

        const val HOME_ID = 0
        const val PERFIL_ID = 1
        const val CRIAR_DESAFIO_ID = 2
        const val GRUPOS_ID = 3
        const val RANKING_GERAL_ID = 4
        const val LOGOUT_ID = 5
    }
}