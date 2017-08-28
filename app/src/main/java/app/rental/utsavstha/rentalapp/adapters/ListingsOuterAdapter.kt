package app.rental.utsavstha.rentalapp.adapters

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.interfaces.CallBacks
import app.rental.utsavstha.rentalapp.adapters.ListingsOuterAdapter.ViewHolder
import kotlinx.android.synthetic.main.listing_recyclerview_item_outer.view.*

/**
 * Created by utsavstha on 8/20/17.
 */

class ListingsOuterAdapter(private val titles: List<String>, private val listingsCallbacks: CallBacks.ListingsAdapterCallBack, private val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listing_recyclerview_item_outer, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = titles[position]
    }

    override fun getItemCount(): Int {
        return titles.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val recyclerView: RecyclerView = itemView.rv_listings_details
        internal val title: TextView = itemView.listing_recyclerview_item_outer_title

        init {
            recyclerView.setHasFixedSize(true)

            val mLayoutManager = LinearLayoutManager(context,
                    LinearLayoutManager.HORIZONTAL, false)
            recyclerView.layoutManager = mLayoutManager

            val listingsAdapter = ListingsAdapter(listingsCallbacks, false)
            recyclerView.adapter = listingsAdapter

            itemView.setOnClickListener { }
        }
    }
}
