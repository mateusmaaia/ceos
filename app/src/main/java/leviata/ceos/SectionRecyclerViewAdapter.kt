package leviata.ceos

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item.view.*


class SectionRecyclerViewAdapter(private val items : ArrayList<String>, private val icon: String, private val context: Context, val listener: (String) -> Unit) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text.text = items[position]
        holder.cardView.setOnClickListener {
            listener(items[position])
        }

        if (icon == "tecnologia"){
            holder.icon.setImageResource(R.drawable.tec_icon)
        } else if (icon == "mat"){
            holder.icon.setImageResource(R.drawable.icon_mat)
        } else if (icon == "fisica"){
            holder.icon.setImageResource(R.drawable.fisic_icon)
        } else if (icon == "quimica"){
            holder.icon.setImageResource(R.drawable.quimic_icon)
        } else if (icon == "hist"){
            holder.icon.setImageResource(R.drawable.hist_icon)
        }

    }

    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val text = view.txtView
    val cardView = view.cardView
    val icon = view.recycleImage
}