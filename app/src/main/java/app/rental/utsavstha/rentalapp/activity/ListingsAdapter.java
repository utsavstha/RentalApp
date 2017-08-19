package app.rental.utsavstha.rentalapp.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.Utils.ShowMessage;
import app.rental.utsavstha.rentalapp.interfaces.ListingsAdapterCallBack;

/**
 * Created by utsavstha on 8/19/17.
 */

public class ListingsAdapter extends RecyclerView.Adapter<ListingsAdapter.ViewHolder> {
    private ListingsAdapterCallBack listingsAdapterCallBack;

    public ListingsAdapter(ListingsAdapterCallBack listingsAdapterCallBack) {
        this.listingsAdapterCallBack = listingsAdapterCallBack;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView menuImage, heart;
        public TextView menuName;

        public ViewHolder(View itemView) {
            super(itemView);

            heart = itemView.findViewById(R.id.listing_item_heart);

            heart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    heart.setImageResource(R.drawable.ic_heart_fill);
                }
            });

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listingsAdapterCallBack.onListingClicked(getAdapterPosition());
                }
            });
        }
    }
}
