package app.rental.utsavstha.rentalapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.Utils.Dialogs;
import app.rental.utsavstha.rentalapp.adapters.ListingsOuterAdapter;
import app.rental.utsavstha.rentalapp.interfaces.CallBacks;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link ListingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListingsOuterAdapter listingsAdapter;
    private RecyclerView listingRecyclerView;

    public ListingFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ListingFragment newInstance(String param1, String param2) {
        ListingFragment fragment = new ListingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_listing, container, false);

        init(rootView);
        return rootView;
    }

    private void init(View rootView) {

        listingRecyclerView = rootView.findViewById(R.id.rv_listings);
        listingRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        listingRecyclerView.setLayoutManager(mLayoutManager);


        listingsAdapter = new ListingsOuterAdapter(getTitles(), new CallBacks.ListingsAdapterCallBack() {
            @Override
            public void onListingClicked(int position) {
                Dialogs.showDialog(getActivity());
            }
        });
        listingRecyclerView.setAdapter(listingsAdapter);
    }

    //todo remove this after backend is ready
    private List<String> getTitles(){
        List<String> titles = new ArrayList<>();
        titles.add("Flatmates & Paying Guests");
        titles.add("For Rent - Flat & Apartment ");
        titles.add("For Rent - House");
        titles.add("For Rent - Land");
        titles.add("For Rent - Office Space");
        titles.add("For Rent - Shutter & Shop Space");
        titles.add("For Sale - Commercial Property");
        titles.add("For Sale - Flat & Apartment");
        titles.add("For Sale - House");
        titles.add("For Sale - Land");
        return titles;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
