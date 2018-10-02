package leviata.ceos

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import leviata.ceos.databinding.FragmentProfileBinding
import leviata.ceos.navigation.NavigationViewModel

class ProfileFragment : Fragment() {

    lateinit var binding: FragmentProfileBinding
    lateinit var viewModel: NavigationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_profile, container, false)

        viewModel = ViewModelProviders.of(activity!!).get(NavigationViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val binding = this.binding ?: return
        val idBadge = arguments?.getString(ID_KEY) ?: return

        binding.idTeste.text = idBadge

        viewModel.select("Ranking")

    }

    companion object {
        private val ID_KEY = "ID_KEY"

        fun newInstance(idBadge: String): ProfileFragment {
            val bundle = Bundle()
            bundle.putString(ID_KEY, idBadge)
            val fragment = ProfileFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}