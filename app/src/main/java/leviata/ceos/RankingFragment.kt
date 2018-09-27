package leviata.ceos

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import leviata.ceos.databinding.FragmentRankingBinding
import kotlinx.android.synthetic.main.fragment_ranking.view.*


class RankingFragment : Fragment() {

    lateinit var binding: FragmentRankingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ranking, container, false)

        val user_column = R.id.name_ranking
        val score_column = R.id.scores
        val position_column = R.id.position

        var users = arrayOf("Wilson Oliveira", "Dário Augusto", "Sabrina Vieira", "Willian Sone", "Marcos Hon-ma", "Valéria Maia", "Fernanda Garcia")
        var scores = arrayOf("152", "139", "130", "125", "112", "100", "79")

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val binding = this.binding ?: return
    }


}