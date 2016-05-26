package com.example.naft;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SQLiteDatabase database = openOrCreateDatabase("db", MODE_PRIVATE, null);
		database.execSQL(
				"CREATE TABLE IF NOT EXISTS Staff(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR NOT NULL);");
		database.execSQL(
				"CREATE TABLE IF NOT EXISTS Place(id INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR NOT NULL);");
		database.execSQL("CREATE TABLE IF NOT EXISTS Mission(id INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " staff INTEGER NOT NULL, place INTEGER NOT NULL, start_year INT NOT NULL, start_month INT NOT NULL,"
				+ " start_day INT NOT NULL, start_hour INT NOT NULL, start_minute INT NOT NULL, end_year INT ,"
				+ " end_month INT, end_day INT ,end_hour INT, end_minute INT,"
				+ " FOREIGN KEY (staff) REFERENCES Staff(id) , FOREIGN KEY (place) REFERENCES Place(id))");
		try {
			Class<?> ourClass = Class.forName("com.example.naft.StaffList");
			Intent ourIntent = new Intent(MainActivity.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
			return rootView;
		}
	}
}
