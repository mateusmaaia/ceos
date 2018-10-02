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
import leviata.ceos.databinding.FragmentGroupBinding

class GroupFragment : Fragment() {
    lateinit var binding: FragmentGroupBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_group, container, false)

        binding.fab.setOnClickListener {
            Toast.makeText(context, "No momento não é possivel criar novos grupos, tente novamente mais tarde.", Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val binding = this.binding ?: return
    }
}