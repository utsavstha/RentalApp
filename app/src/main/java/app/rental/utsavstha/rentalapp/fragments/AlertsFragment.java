package app.rental.utsavstha.rentalapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.Utils.Dialogs;
import app.rental.utsavstha.rentalapp.adapters.AlertsAdapter;
import app.rental.utsavstha.rentalapp.adapters.ListingsAdapter;
import app.rental.utsavstha.rentalapp.interfaces.CallBacks;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link AlertsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AlertsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    AlertsAdapter alertsAdapter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView recyclerView;

    public AlertsFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static AlertsFragment newInstance(String param1, String param2) {
        AlertsFragment fragment = new AlertsFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_alert, container, false);

        init(rootView);
        return rootView;
    }

    private void init(View rootView) {
        recyclerView = rootView.findViewById(R.id.rv_alert);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),
                LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(mLayoutManager);

        alertsAdapter = new AlertsAdapter(new CallBacks.AlertsAdapterCallBack() {
            @Override
            public void onAlertClicked(int position) {

            }
        });

        recyclerView.setAdapter(alertsAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
