package app.rental.utsavstha.rentalapp.adapters

import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.support.v4.content.ContextCompat
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout

import app.rental.utsavstha.rentalapp.R
import app.rental.utsavstha.rentalapp.interfaces.CallBacks

/**
 * Created by utsavstha on 8/23/17.
 */

class PostAdsViewPager(mContext: Context, private val resources: List<Bitmap>,private var postAds: CallBacks.PostAdsCallBack) : PagerAdapter() {
    private var mLayoutInflater: LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getCount(): Int {
        return 5
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object` as LinearLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false)


        val imageView = itemView.findViewById<ImageView>(R.id.iv_post_image)
        imageView.setImageBitmap(resources[position])
        imageView.setOnClickListener { postAds.onImageClicked(position, imageView) }
        container.addView(itemView)
        container.tag = position

        return itemView
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as LinearLayout)
    }

    override fun getItemPosition(`object`: Any?): Int {
        return PagerAdapter.POSITION_NONE
    }
}