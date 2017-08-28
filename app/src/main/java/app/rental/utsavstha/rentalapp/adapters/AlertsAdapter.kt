package app.rental.utsavstha.rentalapp.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.adapters.AlertsAdapter.ViewHolder
import app.rental.utsavstha.rentalapp.interfaces.CallBacks

/**
 * Created by utsavstha on 8/23/17.
 */

class AlertsAdapter(internal var alertsAdapterCallBack: CallBacks.AlertsAdapterCallBack) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.alerts_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 4
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { alertsAdapterCallBack.onAlertClicked(adapterPosition) }
        }
    }
}
