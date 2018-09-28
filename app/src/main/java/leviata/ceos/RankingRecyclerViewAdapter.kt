package leviata.ceos

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_ranking.view.*


class RankingRecyclerViewAdapter(val users : ArrayList<String>, val scores : ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.fragment_ranking, parent, false))
    }

    override fun onBindViewHolder(holder: RankingHolder, position: Int) {
        holder.user.text = users[position]
        holder.score.text = scores[position]

    }

    override fun getItemCount(): Int {
        return users.size
        return scores.size
    }

}

class RankingHolder (view: View) : RecyclerView.ViewHolder(view) {

    val user = view.name_ranking
    val score = view.scores
}