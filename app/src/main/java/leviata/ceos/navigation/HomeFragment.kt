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
        binding.recyclerHome1.setHasFixedSize(true)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerHome1.layoutManager = linearLayoutManager

        binding.recyclerHome2.setHasFixedSize(true)
        val linearLayoutManager2 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerHome2.layoutManager = linearLayoutManager2


        binding.recyclerHome3.setHasFixedSize(true)
        val linearLayoutManager3 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerHome3.layoutManager = linearLayoutManager3

        binding.recyclerHome4.setHasFixedSize(true)
        val linearLayoutManager4 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerHome4.layoutManager = linearLayoutManager4

        binding.recyclerHome5.setHasFixedSize(true)
        val linearLayoutManager5 = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.recyclerHome5.layoutManager = linearLayoutManager5

    }

    private fun populateRecyclerView() {

        //Caro professor, sei que é péssimo fazer dessa forma e não fazer de forma recursiva,
        // mas o tempo nos fez tomar medidas drásticas <3

        val cont = context ?: return
        //1
        val adapter = SectionRecyclerViewAdapter(arrayListOf("Equações", "Integral", "Derivada", "Teorema de LaPlace", "Logaritmos"), "mat", cont){
            (activity as NavigationActivity).presenter.replaceFragment(ChallengeListFragment())
        }
        binding.recyclerHome1.adapter = adapter
        binding.recyclerLabel1.text = "Matemática"


        //2
        val adapter2 = SectionRecyclerViewAdapter(arrayListOf("Array", "Enum", "String", "Condicionais"), "tecnologia", cont){

        }
        binding.recyclerHome2.adapter = adapter2
        binding.recyclerLabel2.text = "Tecnologia"

        //3
        val adapter3 = SectionRecyclerViewAdapter(arrayListOf("Termodinâmica", "Elétrica", "Cinemática", "Mecânica de fluídos"), "fisica",cont){

        }
        binding.recyclerHome3.adapter = adapter3
        binding.recyclerLabel3.text = "Fisica"

        //4
        val adapter4 = SectionRecyclerViewAdapter(arrayListOf("Orgânica", "Cinética química", "Entalpia", "Inorgânica"), "quimica",cont){

        }
        binding.recyclerHome4.adapter = adapter4
        binding.recyclerLabel4.text = "Química"

        //5
        val adapter5 = SectionRecyclerViewAdapter(arrayListOf("Revolução Francesa", "Idade média", "Guerra Fria"), "hist",cont){

        }
        binding.recyclerHome5.adapter = adapter5
        binding.recyclerLabel5.text = "História"
    }
}