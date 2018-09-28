package leviata.ceos

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import leviata.ceos.databinding.FragmentRankingBinding


class RankingFragment : Fragment() {

    lateinit var binding: FragmentRankingBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_ranking, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return
        setUpRecyclerView(binding)
        populateRecyclerView()
    }

    private fun setUpRecyclerView(binding: FragmentRankingBinding) {
        binding.recyclerHome.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerHome.layoutManager = linearLayoutManager
    }

    private fun populateRecyclerView() {

        var users_array = arrayListOf("Wilson Oliveira", "Dário Augusto", "Sabrina Vieira", "Willian Sone", "Marcos Hon-ma", "Valéria Maia", "Fernanda Garcia")
        var scores_array = arrayListOf("152", "139", "130", "125", "112", "100", "79")
        val cont = context ?: return
        val adapter = RankingRecyclerViewAdapter(users_array, scores_array, cont)
        binding.recyclerRanking.adapter = adapter
    }


}