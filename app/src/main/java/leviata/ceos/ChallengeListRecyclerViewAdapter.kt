package leviata.ceos

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.item_challenge_list.view.*


class ChallengeListRecyclerViewAdapter(private val items: ArrayList<String>, private val isNotNull: ArrayList<Boolean>, private val context: Context, val listener: (String) -> Unit) : RecyclerView.Adapter<ChallengeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        return ChallengeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_challenge_list, parent, false))
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        holder.title.text = items[position]
        holder.button.setOnClickListener {
            if(isNotNull[position]) {
                listener(items[position])
            } else {
                if(holder.button.text == "AVISE-ME") {
                    Toast.makeText(context, "Pronto! Você será notificado quando o desafio estiver disponível.", Toast.LENGTH_SHORT).show()
                    holder.button.text = "CANCELAR"
                } else {
                    Toast.makeText(context, "Notificação cancelada!", Toast.LENGTH_SHORT).show()
                    holder.button.text = "AVISE-ME"
                }
            }

        }

        if(isNotNull[position]) {
            holder.button.text = "Resolver"
        } else {
            holder.button.text = "AVISE-ME"
            holder.button.setBackgroundColor(R.color.gray)

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ChallengeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val title = view.recycleChallengeTitle
    val button = view.recycleChallengeButton
}