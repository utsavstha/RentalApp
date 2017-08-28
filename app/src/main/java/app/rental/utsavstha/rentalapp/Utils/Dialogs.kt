package app.rental.utsavstha.rentalapp.Utils

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.view.View
import android.widget.ImageView

import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.activity.MainActivity
import app.rental.utsavstha.rentalapp.constants.AppConstants

/**
 * Created by utsavstha on 8/20/17.
 */

object Dialogs {
    fun showDialog(context: Context) {
        val dialog = Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        dialog.setContentView(R.layout.listings_details_dialog)
        dialog.window!!.attributes.windowAnimations = R.style.DialogAnimation

        val backButton = dialog.findViewById<ImageView>(R.id.iv_listing_details_dialog_back)
        val heartButton = dialog.findViewById<ImageView>(R.id.iv_listing_details_dialog_heart)
        backButton.setOnClickListener { dialog.dismiss() }

        heartButton.setOnClickListener { heartButton.setImageResource(R.drawable.ic_heart_fill) }

        dialog.show()
    }

    fun showTapTargetView(tapFor: String, title: String, description: String, context: Activity, layout: Int, drawableItem: Int) {

        if (PreferencesManager.getPreferences().getBoolean(tapFor, true)) {

            TapTargetView.showFor(context, // `this` is an Activity
                    TapTarget.forView(context.findViewById(layout), title, description)
                            // All options below are optional
                            .outerCircleColor(R.color.colorPrimary)      // Specify a color for the outer circle
                            .outerCircleAlpha(0.96f)            // Specify the alpha amount for the outer circle
                            .targetCircleColor(R.color.colorWhite)   // Specify a color for the target circle
                            .titleTextSize(20)                  // Specify the size (in sp) of the title text
                            .titleTextColor(R.color.colorWhite)      // Specify the color of the title text
                            .descriptionTextSize(14)            // Specify the size (in sp) of the description text
                            .descriptionTextColor(R.color.colorBlack)  // Specify the color of the description text
                            .textColor(R.color.colorWhite)            // Specify a color for both the title and description text
                            .textTypeface(Typeface.SANS_SERIF)  // Specify a typeface for the text
                            .dimColor(R.color.colorBlack)            // If set, will dim behind the view with 30% opacity of the given color
                            .drawShadow(true)                   // Whether to draw a drop shadow or not
                            .cancelable(false)                  // Whether tapping outside the outer circle dismisses the view
                            .tintTarget(true)                   // Whether to tint the target view's color
                            .transparentTarget(false)           // Specify whether the target is transparent (displays the content underneath)
                            .icon(ContextCompat.getDrawable(context, drawableItem))                     // Specify a custom drawable to draw as the target
                            .targetRadius(60), // Specify the target radius (in dp)
                    object : TapTargetView.Listener() {          // The listener can listen for regular clicks, long clicks or cancels
                        override fun onTargetClick(view: TapTargetView) {
                            super.onTargetClick(view)      // This call is optional
                            PreferencesManager.getPreferences().setPreference(tapFor, false)
                            view.dismiss(true)
                        }
                    })
        }

    }
}
