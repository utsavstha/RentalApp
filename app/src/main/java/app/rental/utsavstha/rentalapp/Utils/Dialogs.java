package app.rental.utsavstha.rentalapp.Utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;

import app.rental.utsavstha.rentalapp.R;

/**
 * Created by utsavstha on 8/20/17.
 */

public class Dialogs {
    public static void showDialog(Context context) {
        final Dialog dialog = new Dialog(context, android.R.style.Theme_Black_NoTitleBar_Fullscreen);
        dialog.setContentView(R.layout.listings_details_dialog);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;

        ImageView backButton = dialog.findViewById(R.id.iv_listing_details_dialog_back);
        final ImageView heartButton = dialog.findViewById(R.id.iv_listing_details_dialog_heart);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                heartButton.setImageResource(R.drawable.ic_heart_fill);
            }
        });

        dialog.show();
    }
}
