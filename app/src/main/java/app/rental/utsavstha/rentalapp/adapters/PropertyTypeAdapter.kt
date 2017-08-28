package app.rental.utsavstha.rentalapp.adapters

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.interfaces.CallBacks

import app.rental.utsavstha.rentalapp.adapters.PropertyTypeAdapter.ViewHolder

/**
 * Created by utsavstha on 8/20/17.
 */

class PropertyTypeAdapter(private val titles: List<String>) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.property_type_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = titles[position]
    }

    override fun getItemCount(): Int = titles.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        internal var title: TextView = itemView.findViewById(R.id.tv_property_title)

        init {
            itemView.setOnClickListener { }
        }
    }
}
