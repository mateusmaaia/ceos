package leviata.ceos.navigation

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat.startActivity
import android.support.v4.view.GravityCompat
import android.view.Gravity
import leviata.ceos.*
import leviata.ceos.databinding.ActivityNavigationBinding

class NavigationPresenter(private val mActivity: NavigationActivity, private val mBinding: ActivityNavigationBinding) : LifecycleObserver {

    private var mBackPressedFlag = false

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {

        mBinding.leftDrawer.setNavigationItemSelectedListener { menuItem ->
            changeNavigation(menuItem.itemId)
            closeDrawer()
            true
        }
    }

    private fun changeNavigation(itemIdValue: Int): Boolean {

        //Needs this to avoid stackOverFlow
        if (mBackPressedFlag) {
            mBackPressedFlag = false
            return true
        }

        var intent = Intent(mActivity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP

        when (itemIdValue) {
            NavigationActivity.HOME_ID -> replaceFragment(HomeFragment())
            NavigationActivity.PERFIL_ID -> replaceFragment(ProfileFragment.newInstance("Desafios"))
            NavigationActivity.CRIAR_DESAFIO_ID -> replaceFragment(CreateChallengeFragment())
            NavigationActivity.GRUPOS_ID -> replaceFragment(GroupFragment())
            NavigationActivity.RANKING_GERAL_ID -> replaceFragment(RankingFragment())
            NavigationActivity.LOGOUT_ID -> mActivity.startActivity(intent)

        }

        return true
    }

    fun replaceFragment(fragment: Fragment) {

        mActivity.supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.contentFragment, fragment, "Navigation").commit()
    }


    fun openDrawer() {
        mBinding.drawerLayout.openDrawer(Gravity.START, true)
    }

    fun isDrawerOpen(): Boolean = mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)

    fun closeDrawer() {
        mBinding.drawerLayout.closeDrawer(GravityCompat.START)
    }
}