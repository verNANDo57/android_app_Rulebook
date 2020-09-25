package com.verNANDo57.rulebook_educational;

import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.verNANDo57.rulebook_educational.customthemeengine.app.CustomThemeEngineAppCompatActivity;
import com.verNANDo57.rulebook_educational.for_pills.R;
import com.verNANDo57.rulebook_educational.preferences.RulebookApplicationSharedPreferences;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AppRulebookLiveLoggingActivity extends CustomThemeEngineAppCompatActivity
{
	private LogStringadapter adapter = null;
	private LogReaderTask logReaderTask = null;
	RulebookApplicationSharedPreferences preferences;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		preferences =  new RulebookApplicationSharedPreferences(this);

		super.onCreate(savedInstanceState);

		//Activity Content as LAYOUT
		setContentView(R.layout.app_rulebook_debugging_layout);

		//Some stuff to make LiveLogs working
		ArrayList<String> logarray = new ArrayList<String>();
		ListView searchTextView = findViewById(R.id.debugging_list);
		adapter = new LogStringadapter(this, R.id.txtLogString, logarray);
		searchTextView.setAdapter(adapter);
		logReaderTask = new LogReaderTask();
		logReaderTask.execute();
	}

	protected void onDestroy() {
		logReaderTask.stopTask();

		super.onDestroy();
	}

	//set TextColor
	private int getLogColor(String type) {
		int color = getResources().getColor(R.color.text_normal);
		if (type.equals("D")) {
			color = Color.rgb(255, 129, 0);
		} else if (type.equals("W")) {
			color = Color.rgb(255, 255, 4);
		} else if (type.equals("E")) {
			color = Color.rgb(255, 0, 0);
		} else if (type.equals("I")) {
			color = Color.rgb(217, 136, 0);
		}

		return color;
	}

	private class LogStringadapter extends ArrayAdapter<String> {
		private List<String> objects = null;

		public LogStringadapter(Context context, int textviewid,
								List<String> objects) {
			super(context, textviewid, objects);

			this.objects = objects;
		}

		@Override
		public int getCount() {
			return ((null != objects) ? objects.size() : 0);
		}

		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public String getItem(int position) {
			return ((null != objects) ? objects.get(position) : null);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			View view = convertView;

			if (null == view) {
				LayoutInflater vi = (LayoutInflater) AppRulebookLiveLoggingActivity.this
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = vi.inflate(R.layout.app_debugging_interface, null);
			}

			String data = objects.get(position);

			if (null != data) {
				TextView textview = view
					.findViewById(R.id.txtLogString);
				String type = data.substring(0, 1);
				String line = data.substring(2);

				textview.setText(line);
				textview.setTextColor(getLogColor(type)); //getting TextColor
			}

			return view;
		}
	}

	private class LogReaderTask extends AsyncTask<Void, String, Void> {
		private final String[] LOGCAT_CMD = new String[] { "logcat" };
		private final int BUFFER_SIZE = 1024;

		private boolean isRunning = true;
		private Process logprocess = null;
		private BufferedReader reader = null;
		private String[] line = null;

		@Override
		protected Void doInBackground(Void... params) {
			try {
				logprocess = Runtime.getRuntime().exec(LOGCAT_CMD);
			} catch (IOException e) {
				e.printStackTrace();

				isRunning = false;
			}

			try {
				reader = new BufferedReader(new InputStreamReader(
												logprocess.getInputStream()), BUFFER_SIZE);
			} catch (IllegalArgumentException e) {
				e.printStackTrace();

				isRunning = false;
			}

			line = new String[1];

			try {
				while (isRunning) {
					line[0] = reader.readLine();

					publishProgress(line);
				}
			} catch (IOException e) {
				e.printStackTrace();

				isRunning = false;
			}

			return null;
		}

		@Override
		protected void onCancelled() {
			super.onCancelled();
		}

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
		}

		@Override
		protected void onProgressUpdate(String... values) {
			super.onProgressUpdate(values);

			adapter.add(values[0]);
		}

		public void stopTask() {
			isRunning = false;
			logprocess.destroy();
		}
	}
}
