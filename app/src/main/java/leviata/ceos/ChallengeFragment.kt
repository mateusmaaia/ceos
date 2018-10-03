package leviata.ceos

import android.content.Intent
import android.support.v4.app.Fragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import leviata.ceos.databinding.FragmentChallengeBinding
import leviata.ceos.navigation.NavigationActivity

class ChallengeFragment : Fragment() {
    lateinit var binding: FragmentChallengeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_challenge, container, false)

        binding.btnDisplay.setOnClickListener {
            val radioValue = binding.radioThird.isChecked
            (activity as NavigationActivity).presenter.replaceFragment(ChallengeFeedbackFragment())
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return
    }

}