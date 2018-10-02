package leviata.ceos

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_challenge_list.view.*


class ChallengeListRecyclerViewAdapter(private val items: ArrayList<String>, private val isNotNull: ArrayList<Boolean>, private val context: Context, val listener: (String) -> Unit) : RecyclerView.Adapter<ChallengeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        return ChallengeViewHolder(LayoutInflater.from(context).inflate(R.layout.item_challenge_list, parent, false))
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        holder.title.text = items[position]
        holder.button.setOnClickListener {
            listener(items[position])
        }

        if(isNotNull[position]) {
            holder.button.text = "Resolver"
        } else {
            holder.button.visibility = View.GONE
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