package com.verNANDo57.rulebook_educational;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.core.content.ContextCompat;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.verNANDo57.rulebook_educational.customclasses.AppSomeUtils;
import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;
import com.verNANDo57.rulebook_educational.styleabletoast.StyleableToast;


public class MainActivity extends CustomThemeEngineAppCompatActivity
{
	private static final int TIME_INTERVAL = 1000; //milliseconds, desired time passed between two back presses.
	private long mBackPressed;
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
		//Antimation when activity starts------------------------------------------------
		if (preferences.loadRulebookAnimationsDisableState() == false) {
			TranslateAnimation animate = new TranslateAnimation(
					0, 0, 250, 0);
			animate.setDuration(250);
			animate.setFillAfter(false);
			bar_in_mainlayout.startAnimation(animate);
		}
		//End of Animation---------------------------------------------------------------

		//Hide on SwipeDown
		//if bottombar auto control is disabled
		if (preferences.loadRulebookBottomAppBarAutoHideBooleanState() == false) {
			bar_in_mainlayout.setOnTouchListener(new View.OnTouchListener() {

				float mY;
				float swipeDistance;
				final float REQUIRED_SWIPE = 25;

				@Override
				public boolean onTouch(View v, MotionEvent event) {
					float y = event.getY();

					switch (event.getAction()) {

						case MotionEvent.ACTION_DOWN:
							swipeDistance = 0;
							mY = y;
							break;

						case MotionEvent.ACTION_MOVE:
							swipeDistance += y - mY;
							if (Math.abs(swipeDistance) > REQUIRED_SWIPE) {
								if (swipeDistance > 0) {
									if (bar_in_mainlayout.getVisibility() == View.VISIBLE) {
										if (preferences.loadRulebookAnimationsDisableState() == false) {
											TranslateAnimation animate = new TranslateAnimation(
													0, 0, 0, bar_in_mainlayout.getHeight());
											animate.setDuration(250);
											animate.setFillAfter(false);
											bar_in_mainlayout.startAnimation(animate);
										}
										bar_in_mainlayout.setVisibility(View.GONE);
										swipeDistance = 0;
									}
								}
							}
							mY = y;
							break;
					}
					mY = y;
					return false;
				}
			});
		}

		ImageView main_image = findViewById(R.id.imageview_in_main);
		//if bottombar auto control is disabled
		if (preferences.loadRulebookBottomAppBarAutoHideBooleanState() == false) {
			main_image.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
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
			});
		}
		main_image.setColorFilter(ContextCompat.getColor(this, R.color.coloraccent), android.graphics.PorterDuff.Mode.SRC_IN);

		ScrollView main_layout_scrollview = findViewById(R.id.main_layout_scrollview);
		//if bottombar auto control is enabled
		if (preferences.loadRulebookBottomAppBarAutoHideBooleanState() == true) {
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
	}

   //system navigationbar
	@SuppressLint("ObsoleteSdkInt")
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (Build.VERSION.SDK_INT < Build.VERSION_CODES.ECLAIR && event.getRepeatCount() == 0) {
				onBackPressed();
			}
		}
	return super.onKeyDown(keyCode, event); }   
	public void onBackPressed(){
		if (mBackPressed + TIME_INTERVAL > System.currentTimeMillis()) 
		{ 
			super.onBackPressed();
			finishAffinity();
			return;
		}
		else { new StyleableToast.Builder(getApplicationContext())
					.text(getString(R.string.tap_again_to_exit)) // set text
					.textBold() //set text bold
					.iconStart(AppSomeUtils.getIconWarning()) //icon in start of toast
					.show(); //show custom toast
		}
		mBackPressed = System.currentTimeMillis();
	}
   
	//buttons in activity_main.xml
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
