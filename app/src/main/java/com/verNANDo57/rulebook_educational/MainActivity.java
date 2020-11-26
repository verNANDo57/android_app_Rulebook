package com.verNANDo57.rulebook_educational;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.core.content.ContextCompat;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;


public class MainActivity extends CustomThemeEngineAppCompatActivity
{
	RulebookApplicationSharedPreferences preferences;

	@SuppressLint("ClickableViewAccessibility")
	public void onCreate(Bundle savedInstanceState) {
		preferences = new RulebookApplicationSharedPreferences(this);

		super.onCreate(savedInstanceState);

		//Activity Content as LAYOUT
		setContentView(R.layout.app_bottomappbar_in_mainlayout);

		//BottomAppBar
		final BottomAppBar bar_in_mainlayout = findViewById(R.id.bar_in_mainlayout);
		setSupportActionBar(bar_in_mainlayout);

		ImageView main_image = findViewById(R.id.imageview_in_main);
		main_image.setColorFilter(ContextCompat.getColor(this, R.color.colorAccent), android.graphics.PorterDuff.Mode.SRC_IN);

		ScrollView main_layout_scrollview = findViewById(R.id.main_layout_scrollview);
			main_layout_scrollview.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
				@Override
				public void onScrollChanged() {
					//see https://gist.github.com/aqua30/e8623abaff190ee86727ee5ae8dac82a
					int movement = main_layout_scrollview.getScrollY();

					if (movement >= 100) {
						if (bar_in_mainlayout.getVisibility() == View.VISIBLE) {
							if (preferences.loadRulebookAnimationsDisableState() == false) {
								TranslateAnimation animate = new TranslateAnimation(
										0, 0, 0, bar_in_mainlayout.getHeight());
								animate.setDuration(250);
								animate.setFillAfter(false);
								bar_in_mainlayout.startAnimation(animate);
							}
							bar_in_mainlayout.setVisibility(View.GONE);
						}
					} else if (movement >= -100) {
						if (bar_in_mainlayout.getVisibility() == View.GONE) {
							if (preferences.loadRulebookAnimationsDisableState() == false) {
								TranslateAnimation animate = new TranslateAnimation(
										0, 0, bar_in_mainlayout.getHeight(), 0);
								animate.setDuration(250);
								animate.setFillAfter(false);
								bar_in_mainlayout.startAnimation(animate);
							}
							bar_in_mainlayout.setVisibility(View.VISIBLE);
						}
					}
				}
			});
		}

	public void app_exit(View v) {
		androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
		builder.setTitle(getString(R.string.app_exit));
		builder.setIcon(R.drawable.ic_warning_outline);
		builder.setMessage(getString(R.string.are_you_sure));
		builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finishAffinity();
			}
		});
		builder.setNegativeButton(getString(R.string.no), new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		androidx.appcompat.app.AlertDialog alert = builder.create();
		alert.show();
	}
	
	public void app_about(View v){ Intent AppCreditsActivity = new Intent(this, AppAboutApplicationActivity.class);     startActivity(AppCreditsActivity); }
	public void app_rules(View View){ Intent AppChooseYourDestiny = new Intent(this, AppChooseYourDestiny.class);     startActivity(AppChooseYourDestiny); }


}
