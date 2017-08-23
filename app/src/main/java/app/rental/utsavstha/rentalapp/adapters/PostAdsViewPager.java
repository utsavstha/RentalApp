package app.rental.utsavstha.rentalapp.adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.List;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.Utils.ShowMessage;

/**
 * Created by utsavstha on 8/23/17.
 */

public class PostAdsViewPager extends PagerAdapter {

    private final List<Integer> resources;
    Context mContext;
    LayoutInflater mLayoutInflater;

    public PostAdsViewPager(Context context, List<Integer> resources) {
        mContext = context;
        this.resources = resources;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return resources.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_gitem, container, false);

        ImageView imageView = itemView.findViewById(R.id.iv_post_image);
        imageView.setImageResource(resources.get(position));
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowMessage.toast(position+"");
            }
        });
        container.addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}