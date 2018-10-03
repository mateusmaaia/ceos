package leviata.ceos.navigation

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import leviata.ceos.R
import leviata.ceos.RankingRecyclerViewAdapter
import leviata.ceos.databinding.FragmentRankingBinding


class RankingFragment : Fragment() {

    lateinit var binding: FragmentRankingBinding
    lateinit var viewModel: NavigationViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ranking, container, false)

        viewModel = ViewModelProviders.of(activity!!).get(NavigationViewModel::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return

        setUpRecyclerView(binding)
        populateRecyclerView()
    }

    private fun setUpRecyclerView(binding: FragmentRankingBinding) {
        binding.recyclerRanking.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.recyclerRanking.layoutManager = linearLayoutManager
    }

    private fun populateRecyclerView() {

        var usersArray = arrayListOf("Wilson Oliveira", "Dário Augusto", "Sabrina Vieira", "Daniel", "Marcos Hon-ma", "Valéria Maia", "Fernanda Garcia")
        var scoresArray = arrayListOf("152", "139", "130", "125", "112", "100", "79")
        var rankingPositions = arrayListOf("1", "2", "3", "4", "5", "6", "7")
        val cont = context ?: return
        val adapter = RankingRecyclerViewAdapter(rankingPositions, usersArray, scoresArray, cont)
        binding.recyclerRanking.adapter = adapter

    }


}