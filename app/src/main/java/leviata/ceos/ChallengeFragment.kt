package leviata.ceos

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import leviata.ceos.databinding.FragmentChallengeBinding
import leviata.ceos.navigation.NavigationActivity
import android.text.method.ScrollingMovementMethod
import android.widget.Scroller



class ChallengeFragment : Fragment() {
    lateinit var binding: FragmentChallengeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_challenge, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return

        binding.btnDisplay.setOnClickListener {
            val radioButtonID = binding.radioQuestion.checkedRadioButtonId
            var radioButton = binding.radioQuestion.findViewById(radioButtonID) as RadioButton
            (activity as NavigationActivity).presenter.replaceFragment(ChallengeFeedbackFragment.newInstance(binding.radioThird.isChecked, radioButton.text.toString()))
        }
    }

    companion object {
        private val IS_CORRECT = "IS_CORRECT"
        private val TEXT = "TEXT"

        fun newInstance(isCorrect: Boolean, text: String): ChallengeFragment {
            val bundle = Bundle()
            bundle.putBoolean(IS_CORRECT, isCorrect)
            bundle.putString(TEXT, text)
            val fragment = ChallengeFragment()
            fragment.arguments = bundle
            return fragment
        }
    }

}