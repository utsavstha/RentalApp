package app.rental.utsavstha.rentalapp.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by utsavstha on 8/19/17.
 */

public class ImageLoader {

    public static void load(Context context,String url, ImageView imageView){
        Picasso.with(context).load(url).into(imageView);
    }
}
