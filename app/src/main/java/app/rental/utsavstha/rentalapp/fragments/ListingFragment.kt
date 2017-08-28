package app.rental.utsavstha.rentalapp.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import java.util.ArrayList

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.Utils.Dialogs
import app.rental.utsavstha.rentalapp.adapters.ListingsOuterAdapter
import app.rental.utsavstha.rentalapp.interfaces.CallBacks

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the [ListingFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListingFragment : Fragment() {

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    private var listingsAdapter: ListingsOuterAdapter? = null
    private lateinit var listingRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mParam1 = arguments.getString(ARG_PARAM1)
            mParam2 = arguments.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val rootView = inflater!!.inflate(R.layout.fragment_listing, container, false)

        init(rootView)
        return rootView
    }

    private fun init(rootView: View) {

        listingRecyclerView = rootView.findViewById(R.id.rv_listings)
        listingRecyclerView.setHasFixedSize(true)

        val mLayoutManager = LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL, false)
        listingRecyclerView.layoutManager = mLayoutManager


        listingsAdapter = ListingsOuterAdapter(titles, (object : CallBacks.ListingsAdapterCallBack {
            override fun onListingClicked(position: Int) {
                Dialogs.showDialog(activity)
            }
        }), activity)
        listingRecyclerView.adapter = listingsAdapter
    }

    //todo remove this after backend is ready
    private val titles: List<String>
        get() {
            val titles = ArrayList<String>()
            titles.add("Flatmates & Paying Guests")
            titles.add("For Rent - Flat & Apartment ")
            titles.add("For Rent - House")
            titles.add("For Rent - Land")
            titles.add("For Rent - Office Space")
            titles.add("For Rent - Shutter & Shop Space")
            titles.add("For Sale - Commercial Property")
            titles.add("For Sale - Flat & Apartment")
            titles.add("For Sale - House")
            titles.add("For Sale - Land")
            return titles
        }

    override fun onDetach() {
        super.onDetach()
    }

    companion object {
        // TODO: Rename parameter arguments, choose names that match
        // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
        private val ARG_PARAM1 = "param1"
        private val ARG_PARAM2 = "param2"

        // TODO: Rename and change types and number of parameters
        fun newInstance(param1: String, param2: String): ListingFragment {
            val fragment = ListingFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
