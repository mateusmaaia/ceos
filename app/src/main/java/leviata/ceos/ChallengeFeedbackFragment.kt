package leviata.ceos

import android.content.Intent
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return

        binding.btnBack.setOnClickListener {
            (activity as NavigationActivity).presenter.replaceFragment(HomeFragment())
        }

        binding.btnIndication.setOnClickListener {
            val sendIntent: Intent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "VAI BRASIL")
                type = "text/plain"
            }
            startActivity(sendIntent)
        }

        binding.radioAnswer.text = arguments?.getString(TEXT) ?:  ""

        if(arguments?.getBoolean(IS_CORRECT) == true){
            binding.tipFeedback.visibility = View.GONE
            binding.tipTitle.visibility = View.GONE
            binding.answerFeedback.text = "Acertou"
        }
    }

    companion object {
        private val IS_CORRECT = "IS_CORRECT"
        private val TEXT = "TEXT"

        fun newInstance(isCorrect: Boolean, text: String): ChallengeFeedbackFragment {
            val bundle = Bundle()
            bundle.putBoolean(IS_CORRECT, isCorrect)
            bundle.putString(TEXT, text)
            val fragment = ChallengeFeedbackFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}