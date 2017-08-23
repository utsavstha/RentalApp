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

public class PropertyTypeAdapter extends RecyclerView.Adapter<PropertyTypeAdapter.ViewHolder> {

    private final List<String> titles;

    public PropertyTypeAdapter(List<String> titles) {
        this.titles = titles;
    }

    @Override
    public PropertyTypeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.property_type_item, parent, false);
        return new PropertyTypeAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PropertyTypeAdapter.ViewHolder holder, int position) {
        holder.title.setText(titles.get(position));
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_property_title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
