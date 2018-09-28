package leviata.ceos.navigation

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import leviata.ceos.R
import leviata.ceos.SectionRecyclerViewAdapter
import leviata.ceos.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return
        setUpRecyclerView(binding)
        populateRecyclerView()
    }

    private fun setUpRecyclerView(binding: FragmentHomeBinding) {
        binding.recyclerHome.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerHome.layoutManager = linearLayoutManager
    }

    private fun populateRecyclerView() {

        val cont = context ?: return
        val adapter = SectionRecyclerViewAdapter(arrayListOf("Array", "Enum", "String", "Condicionais"), cont)
        binding.recyclerHome.adapter = adapter
        binding.recyclerLabel.text = "Tecnologia"
    }
}