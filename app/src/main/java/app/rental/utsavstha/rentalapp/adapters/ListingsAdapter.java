package app.rental.utsavstha.rentalapp.adapters;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.interfaces.CallBacks;

/**
 * Created by utsavstha on 8/19/17.
 */

public class ListingsAdapter extends RecyclerView.Adapter<ListingsAdapter.ViewHolder> {
    private final boolean isSearchListings;
    private CallBacks.ListingsAdapterCallBack listingsAdapterCallBack;

    public ListingsAdapter(CallBacks.ListingsAdapterCallBack  listingsAdapterCallBack, boolean isSearchListings) {
        this.listingsAdapterCallBack = listingsAdapterCallBack;
        this.isSearchListings = isSearchListings;
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
        return 8;
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
            if(isSearchListings){
                CardView.LayoutParams params =  new CardView.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );
                params.setMargins(8, 8, 8, 8);
                itemView.setLayoutParams(params);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listingsAdapterCallBack.onListingClicked(getAdapterPosition());
                }
            });
        }
    }
}
