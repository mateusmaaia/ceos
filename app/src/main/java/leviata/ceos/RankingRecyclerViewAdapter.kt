package leviata.ceos

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_ranking.view.*


class RankingRecyclerViewAdapter(private val positions: ArrayList<String>, private val users: ArrayList<String>, private val scores: ArrayList<String>, private val context: Context) : RecyclerView.Adapter<RankingHolder>() {

    override fun onBindViewHolder(holder: RankingHolder, position: Int) {
        holder.position.text = positions[position]
        holder.user.text = users[position]
        holder.score.text = scores[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RankingHolder {
        return RankingHolder(LayoutInflater.from(context).inflate(R.layout.item_ranking, parent, false))
    }


    override fun getItemCount(): Int {
        return users.size
    }

}

class RankingHolder(view: View) : RecyclerView.ViewHolder(view) {

    val position = view.positionRanking
    val user = view.userNameRanking
    val score = view.scoreRanking
}