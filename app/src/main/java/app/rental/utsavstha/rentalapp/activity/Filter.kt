package app.rental.utsavstha.rentalapp.activity

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.Window
import android.widget.ImageView
import android.widget.RelativeLayout

import java.util.ArrayList

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.Utils.Dialogs
import app.rental.utsavstha.rentalapp.adapters.ListingsOuterAdapter
import app.rental.utsavstha.rentalapp.adapters.PropertyTypeAdapter
import app.rental.utsavstha.rentalapp.interfaces.CallBacks

class Filter : AppCompatActivity() {

    private lateinit var back: ImageView
    private lateinit var propertyType: RelativeLayout
    private lateinit var propertyTypeRecyclerView: RecyclerView
    private lateinit var propertyTypeAdapter: PropertyTypeAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter)
        back = findViewById(R.id.iv_listing_details_dialog_back)
        propertyType = findViewById(R.id.rl_property_type)

        propertyType.setOnClickListener { showTypesDialog() }

        back.setOnClickListener { onBackPressed() }
    }

    private fun showTypesDialog() {
        val dialog = Dialog(this@Filter, android.R.style.Theme_Material_Dialog)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.property_type_dialog)
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation

        propertyTypeRecyclerView = dialog.findViewById(R.id.rv_property_type_dialog)
        propertyTypeRecyclerView.setHasFixedSize(true)

        val mLayoutManager = LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false)
        propertyTypeRecyclerView.layoutManager = mLayoutManager


        propertyTypeAdapter = PropertyTypeAdapter(titles)
        propertyTypeRecyclerView.adapter = propertyTypeAdapter


        dialog.show()
    }

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
}
