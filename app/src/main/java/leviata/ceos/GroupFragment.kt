package leviata.ceos

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import leviata.ceos.MessageUtil.showMessage
import leviata.ceos.databinding.FragmentGroupBinding

class GroupFragment : Fragment() {
    lateinit var binding: FragmentGroupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_group, container, false)

        binding.fab.setOnClickListener {
            Toast.makeText(context, "Consiga 2.000 pontos para liberar a criação de grupos! ", Toast.LENGTH_SHORT).show()
        }

        binding.group1.setOnClickListener {
            Toast.makeText(context, "No momento não é possivel criar novos grupos, tente novamente mais tarde.", Toast.LENGTH_SHORT).show()
        }

        binding.group2.setOnClickListener {
            Toast.makeText(context, "No momento não é possivel criar novos grupos, tente novamente mais tarde.", Toast.LENGTH_SHORT).show()
        }

        binding.group3.setOnClickListener {
            showMessage(context, "No momento só você faz parte do grupo %s, deseja convidar novos membros?", "OS CAMPEÕES")
        }

        binding.group2.setOnClickListener {
            Toast.makeText(context, "Você não tem permissão para convidar novos membros para o grupo 'OS FILÓSOFOS'.", Toast.LENGTH_SHORT).show()
        }

        binding.group1.setOnClickListener {
            showMessage(context, "No momento só você faz parte do grupo %s, deseja convidar novos membros?", "FIAP")
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return
    }
}