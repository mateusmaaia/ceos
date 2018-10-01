package leviata.ceos.navigation

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class NavigationViewModel : ViewModel() {

    private val selected = MutableLiveData<String>()

    fun select(item: String) {
        selected.value = item
    }

    fun getSelected(): LiveData<String> {
        return selected
    }
}