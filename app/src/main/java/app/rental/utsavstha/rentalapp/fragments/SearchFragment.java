package app.rental.utsavstha.rentalapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.activity.Filter;
import app.rental.utsavstha.rentalapp.adapters.SearchPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link SearchFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SearchFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TabLayout tabLayout;
    private ViewPager searchResults;
    private TextView filter;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private SearchPagerAdapter searchResultsAdapter;
    public SearchFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static SearchFragment newInstance(String param1, String param2) {
        SearchFragment fragment = new SearchFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);

        init(rootView);
        return rootView;
    }

    private void init(View rootView) {
        searchResults = rootView.findViewById(R.id.vp_search_results);
        tabLayout = rootView.findViewById(R.id.tl_search);
        filter = rootView.findViewById(R.id.tv_filter);

        searchResultsAdapter = new SearchPagerAdapter(getChildFragmentManager());
        searchResults.setAdapter(searchResultsAdapter);

        tabLayout.addTab(tabLayout.newTab().setText("LIST RESULTS"));
        tabLayout.addTab(tabLayout.newTab().setText("MAP RESULTS"));

        searchResults.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                searchResults.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), Filter.class));
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
