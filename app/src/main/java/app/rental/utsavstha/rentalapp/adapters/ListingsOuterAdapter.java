package app.rental.utsavstha.rentalapp.adapters;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.interfaces.CallBacks;

import static app.rental.utsavstha.rentalapp.RentApplication.getContext;

/**
 * Created by utsavstha on 8/20/17.
 */

public class ListingsOuterAdapter extends RecyclerView.Adapter<ListingsOuterAdapter.ViewHolder> {

    private final List<String> titles;
    private final CallBacks.ListingsAdapterCallBack listingsCallbacks;

    public ListingsOuterAdapter(List<String> titles, CallBacks.ListingsAdapterCallBack listingsCallback) {
        this.titles = titles;
        this.listingsCallbacks = listingsCallback;
    }

    @Override
    public ListingsOuterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listing_recyclerview_item_outer, parent, false);
        return new ListingsOuterAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ListingsOuterAdapter.ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RecyclerView recyclerView;
        private TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.listing_recyclerview_item_outer_title);
            recyclerView = itemView.findViewById(R.id.rv_listings_details);
            recyclerView.setHasFixedSize(true);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),
                    LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(mLayoutManager);

            ListingsAdapter listingsAdapter = new ListingsAdapter(listingsCallbacks, false);
            recyclerView.setAdapter(listingsAdapter);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
