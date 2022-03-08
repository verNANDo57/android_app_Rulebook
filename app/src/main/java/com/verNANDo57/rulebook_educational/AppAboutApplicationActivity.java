/*
 * Author: VerNANDo57 <silvenation@gmail.com>
 * date: 2022/01/24 6:01PM GMT+7
 */

package com.verNANDo57.rulebook_educational;

import static com.verNANDo57.rulebook_educational.utils.AppUtils.LOG_TAG;
import static com.verNANDo57.rulebook_educational.utils.AppUtils.TRANSLATE_DIRECTION_BOTTOM;
import static com.verNANDo57.rulebook_educational.utils.AppUtils.TRANSLATE_DIRECTION_TOP;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.verNANDo57.rulebook_educational.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.extradata.R;
import com.verNANDo57.rulebook_educational.preferences.AppSettingsActivity;
import com.verNANDo57.rulebook_educational.utils.AppUtils;

public class AppAboutApplicationActivity extends CustomThemeEngineAppCompatActivity
{

	@SuppressLint("SetTextI18n")
	public void onCreate(Bundle savedInstanceState)
    {
		super.onCreate(savedInstanceState);

        setContentView(R.layout.app_bottomappbar_about);

		final FloatingActionButton fab_in_about = findViewById(R.id.fab_in_about);
		fab_in_about.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view){
				finish();
			}
		});
		final BottomAppBar bar_in_credits = findViewById(R.id.bar_in_about);
		setSupportActionBar(bar_in_credits);
		AppUtils.setTranslateAnimation(bar_in_credits, TRANSLATE_DIRECTION_TOP, (float) 250);
		bar_in_credits.setNavigationOnClickListener(new NavigationView.OnClickListener() {
			@Override
			public void onClick(View v) {
				BottomNavAmongActivitiesFragment BottomNavBetweenActivities = new BottomNavAmongActivitiesFragment();
				BottomNavBetweenActivities.show(getSupportFragmentManager(), LOG_TAG);
			}
		});

		TextView appaboutTextView2 = findViewById(R.id.appaboutTextView2);
		appaboutTextView2.setText(getString(R.string.app_about_extended) + AppUtils.getApplicationVersionInfo(this, AppUtils.PACKAGEMANAGER_GET_APP_VERISON_NAME));

		ScrollView about_scrollview = findViewById(R.id.about_scrollview);
		about_scrollview.getViewTreeObserver().addOnScrollChangedListener(new ViewTreeObserver.OnScrollChangedListener() {
			@Override
			public void onScrollChanged() {
				//see https://gist.github.com/aqua30/e8623abaff190ee86727ee5ae8dac82a
				int movement = about_scrollview.getScrollY();
				if(movement >= 100){
					if (bar_in_credits.getVisibility() == View.VISIBLE) {
						AppUtils.setTranslateAnimation(bar_in_credits, TRANSLATE_DIRECTION_BOTTOM);
						bar_in_credits.setVisibility(View.GONE);
						fab_in_about.hide();
					}
				} else if(movement >= -100){
					if (bar_in_credits.getVisibility() == View.GONE) {
						AppUtils.setTranslateAnimation(bar_in_credits, TRANSLATE_DIRECTION_TOP);
						bar_in_credits.setVisibility(View.VISIBLE);
						fab_in_about.show();
					}
				}
			}
		});

		Button review_page = findViewById(R.id.review_page);
		review_page.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				rate_us();
			}
		});

		ImageButton buttonGithub = findViewById(R.id.buttongit);
		buttonGithub.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent githubIntent = new Intent(Intent.ACTION_VIEW);
				githubIntent.setData(Uri.parse("https://github.com/verNANDo57"));
				startActivity(githubIntent);
			}
		});

		ImageButton buttonVk = findViewById(R.id.buttonvk);
		buttonVk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent vkIntent = new Intent(Intent.ACTION_VIEW);
				vkIntent.setData(Uri.parse("https://vk.com/vernando57"));
				startActivity(vkIntent);
		}
		});

		ImageButton buttonTelegram = findViewById(R.id.buttontg);
		buttonTelegram.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent telegramIntent = new Intent(Intent.ACTION_VIEW);
				telegramIntent.setData(Uri.parse("https://t.me/VerNANDo57"));
				startActivity(telegramIntent);
		}
		});
	}

	public boolean onCreateOptionsMenu(@NonNull Menu menu) {
		getMenuInflater().inflate(R.menu.app_menu, menu);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item)
	{
		int id = item.getItemId();

		if (id == R.id.preferences_screen) {
			startActivity(new Intent(this, AppSettingsActivity.class));
		} else if (id == R.id.exit_actionbar_extended) {
			androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(this);
			builder.setTitle(getString(R.string.app_exit));
			builder.setMessage(getString(R.string.are_you_sure));
			builder.setIcon(R.drawable.ic_warning);
			builder.setPositiveButton(getString(R.string.yes), new DialogInterface.OnClickListener(){
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
		return super.onOptionsItemSelected(item);
	}

	public void rate_us(){
		final Intent rate_app = new Intent(this, AppRatingActivity.class);
		rate_app.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
		rate_app.addFlags(Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
		startActivity(rate_app);
	}
}
