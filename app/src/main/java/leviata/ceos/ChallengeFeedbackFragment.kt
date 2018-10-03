package leviata.ceos

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import leviata.ceos.databinding.FragmentChallengeFeedbackBinding
import leviata.ceos.navigation.ChallengeListFragment
import leviata.ceos.navigation.HomeFragment
import leviata.ceos.navigation.NavigationActivity

class ChallengeFeedbackFragment : Fragment() {
    lateinit var binding: FragmentChallengeFeedbackBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_challenge_feedback, container, false)

        binding.btnBack.setOnClickListener {
            (activity as NavigationActivity).presenter.replaceFragment(HomeFragment())
        }

        binding.btnIndication.setOnClickListener {
            Toast.makeText(context, "Funcionalidade não disponível no momento", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return
    }
}