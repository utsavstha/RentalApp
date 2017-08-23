package app.rental.utsavstha.rentalapp.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import app.rental.utsavstha.rentalapp.R;
import app.rental.utsavstha.rentalapp.Utils.ShowMessage;
import app.rental.utsavstha.rentalapp.adapters.PostAdsViewPager;
import me.relex.circleindicator.CircleIndicator;

public class PostAds extends AppCompatActivity {

    PostAdsViewPager postAdsViewPager;
    ViewPager viewPager;
    CircleIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_ads);
        viewPager = findViewById(R.id.vp_images);
        indicator = findViewById(R.id.indicator);

        List<Integer> resources = new ArrayList<>();
        resources.add(R.drawable.ic_image_placeholder);
        resources.add(R.drawable.ic_image_placeholder);
        resources.add(R.drawable.test_image);
        resources.add(R.drawable.test_image);

        postAdsViewPager = new PostAdsViewPager(this, resources);
        viewPager.setAdapter(postAdsViewPager);
        indicator.setViewPager(viewPager);
        postAdsViewPager.registerDataSetObserver(indicator.getDataSetObserver());
    }
}
