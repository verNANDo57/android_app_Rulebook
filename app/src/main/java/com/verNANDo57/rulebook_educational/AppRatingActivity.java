package com.verNANDo57.rulebook_educational;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.ScrollView;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;

public class AppRatingActivity extends CustomThemeEngineAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.app_bottomappbar_rate);

        final BottomAppBar bar_in_rating_page = findViewById(R.id.bar_in_rating_page);
        setSupportActionBar(bar_in_rating_page);
        AppUtils.setTranslateAnimation(bar_in_rating_page, "to_top", (float) 250);
        ScrollView rating_page_scrollview = findViewById(R.id.rating_page_scrollview);
        rating_page_scrollview.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
            @Override
            public void onScrollChanged() {
                //see https://gist.github.com/aqua30/e8623abaff190ee86727ee5ae8dac82a
                int movement = rating_page_scrollview.getScrollY();

                if(movement >= 100){
                    if (bar_in_rating_page.getVisibility() == View.VISIBLE) {
                        AppUtils.setTranslateAnimation(bar_in_rating_page, "to_bottom");
                        bar_in_rating_page.setVisibility(View.GONE);
                    }
                } else if(movement >= -100){
                    if (bar_in_rating_page.getVisibility() == View.GONE) {
                        AppUtils.setTranslateAnimation(bar_in_rating_page, "to_top");
                        bar_in_rating_page.setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        RatingBar rating_bar = findViewById(R.id.rating_bar);
        AppRatingVector app_agressive_rating_vector = findViewById(R.id.app_agressive_rating_vector);
        rating_bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d("Rating", String.valueOf(rating));
                app_agressive_rating_vector.setSmiley(rating);
            }
        });

        Button review_send = findViewById(R.id.review_send_button);
        review_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendReview();
            }
        });
    }

    public void SendReview(){
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screeenwidth = dm.widthPixels;
        int screenheight = dm.heightPixels;
        int screendens = dm.densityDpi;
        double wi = (double)screeenwidth / (double)screendens;
        double hi = (double)screenheight / (double)screendens;
        double x = Math.pow(wi, 2);
        double y = Math.pow(hi, 2);
        double screenInches = Math.sqrt(x+y);
        screenInches = (double) Math.round(screenInches * 10) / 10;

        EditText review_box = findViewById(R.id.review_box);
        RatingBar rating_bar = findViewById(R.id.rating_bar);

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{getString(R.string.app_dev_email)});
        email.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.app_dev_part1) + String.valueOf(rating_bar.getRating()) + getString(R.string.app_dev_part2));
        email.putExtra(Intent.EXTRA_TEXT, review_box.getText().toString() + "\n" +"\n"
                + getString(R.string.review_device_name) + Build.DEVICE + "\n"
                + getString(R.string.review_device_model) + Build.MODEL + "\n"
                + getString(R.string.review_device_manufacter) + Build.MANUFACTURER + "\n"
                + getString(R.string.review_oc_name) + Build.ID + "\n"
                + getString(R.string.review_device_sdk_version) + Build.VERSION.SDK_INT + "\n"
                + getString(R.string.review_device_hardware) + Build.HARDWARE + "\n"
                + getString(R.string.review_device_brand) + Build.BRAND + "\n"
                + getString(R.string.review_device_fingerprint) + Build.FINGERPRINT + "\n"
                + getString(R.string.review_device_android_version) + Build.VERSION.RELEASE + "\n"
                + getString(R.string.review_device_screen_resolution) + screeenwidth + "x" + screenheight + "\n"
                + getString(R.string.review_device_current_dpi_value) + screenInches);
        //need this to prompts email client only
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, getString(R.string.app_choose_email_client)));
    }
}
