package leviata.ceos.navigation

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import leviata.ceos.ChallengeFragment
import leviata.ceos.ChallengeListRecyclerViewAdapter
import leviata.ceos.R
import leviata.ceos.databinding.FragmentChallengeListBinding


class ChallengeListFragment : Fragment() {

    lateinit var binding: FragmentChallengeListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_challenge_list, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return
        setUpRecyclerView(binding)
        populateRecyclerView()
    }

    private fun setUpRecyclerView(binding: FragmentChallengeListBinding) {
        binding.challengeRecyclerView.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        binding.challengeRecyclerView.layoutManager = linearLayoutManager

    }

    private fun populateRecyclerView() {

        val cont = context ?: return
        val adapter = ChallengeListRecyclerViewAdapter(arrayListOf("Raízes da equação", "Equações biquadradas", "A exponenciação", "Gráficos de primeiro grau", "Desafio de igualdade", "Eixo das ordenadas", "Áreas de Gráficos", "Desafio de Investimentos", "Distância de Ponto a ponto", "Equação de reta", "Equações trigonométricas"), arrayListOf(true, false, false, false, false, false, false, false, false, false, false), cont) {
            (activity as NavigationActivity).presenter.replaceFragment(ChallengeFragment())
        }
        binding.challengeRecyclerView.adapter = adapter
        binding.challengeViewTitle.text = "Equações"

    }
}