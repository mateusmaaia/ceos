package leviata.ceos.navigation

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.view.Gravity
import leviata.ceos.ProfileFragment
import leviata.ceos.R
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

    private fun changeNavigation(itemIdValue: Int): Boolean{

        //Needs this to avoid stackOverFlow
        if(mBackPressedFlag) {
            mBackPressedFlag = false
            return true
        }

        when (itemIdValue) {
            NavigationActivity.PERFIL_ID -> replaceFragment(ProfileFragment())
//            NavigationActivity.CRIAR_DESAFIO_ID -> replaceFragment(ChallengesFragment())
//            NavigationActivity.GRUPOS_ID -> replaceFragment(GroupsFragment())
//            NavigationActivity.RANKING_GERAL_ID -> replaceFragment(RankingFragment())
//            NavigationActivity.LOGOUT_ID -> Logout()

        }

        return true
    }

    private fun replaceFragment(fragment: Fragment){
        mActivity.supportFragmentManager.beginTransaction().addToBackStack(null).replace(R.id.contentFragment, fragment, "Navigation").commit()
    }


    fun openDrawer(){
        mBinding.drawerLayout.openDrawer(Gravity.START, true)
    }

    fun isDrawerOpen(): Boolean = mBinding.drawerLayout.isDrawerOpen(GravityCompat.START)

    fun closeDrawer() {
        mBinding.drawerLayout.closeDrawer(GravityCompat.START)
    }
}