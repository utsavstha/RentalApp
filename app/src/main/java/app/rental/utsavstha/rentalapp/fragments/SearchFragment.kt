package app.rental.utsavstha.rentalapp.fragments

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.activity.Filter
import app.rental.utsavstha.rentalapp.adapters.SearchPagerAdapter

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {
    private var tabLayout: TabLayout? = null
    private var searchResults: ViewPager? = null
    private var filter: TextView? = null

    // TODO: Rename and change types of parameters
    private var mParam1: String? = null
    private var mParam2: String? = null
    private var searchResultsAdapter: SearchPagerAdapter? = null

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
        val rootView = inflater!!.inflate(R.layout.fragment_search, container, false)

        init(rootView)
        return rootView
    }

    private fun init(rootView: View) {
        searchResults = rootView.findViewById(R.id.vp_search_results)
        tabLayout = rootView.findViewById(R.id.tl_search)
        filter = rootView.findViewById(R.id.tv_filter)

        searchResultsAdapter = SearchPagerAdapter(childFragmentManager)
        searchResults!!.adapter = searchResultsAdapter

        tabLayout!!.addTab(tabLayout!!.newTab().setText("LIST RESULTS"))
        tabLayout!!.addTab(tabLayout!!.newTab().setText("MAP RESULTS"))

        searchResults!!.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                searchResults!!.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {

            }

            override fun onTabReselected(tab: TabLayout.Tab) {

            }
        })

        filter!!.setOnClickListener { startActivity(Intent(activity, Filter::class.java)) }
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
        fun newInstance(param1: String, param2: String): SearchFragment {
            val fragment = SearchFragment()
            val args = Bundle()
            args.putString(ARG_PARAM1, param1)
            args.putString(ARG_PARAM2, param2)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
