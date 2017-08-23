package app.rental.utsavstha.rentalapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.interfaces.CallBacks;

/**
 * Created by utsavstha on 8/23/17.
 */

public class AlertsAdapter extends RecyclerView.Adapter<AlertsAdapter.ViewHolder> {

    CallBacks.AlertsAdapterCallBack alertsAdapterCallBack;
    public AlertsAdapter(CallBacks.AlertsAdapterCallBack alertsAdapterCallBack) {
        this.alertsAdapterCallBack = alertsAdapterCallBack;
    }

    @Override
    public AlertsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.alerts_list_item, parent, false);
        return new AlertsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AlertsAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    alertsAdapterCallBack.onAlertClicked(getAdapterPosition());
                }
            });
        }
    }
}
