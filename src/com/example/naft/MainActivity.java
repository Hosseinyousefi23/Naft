package com.example.naft;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView lv;
	CheckBox staff_cb , mission_cb,place_cb;
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
		
		
		lv = (ListView) findViewById(R.id.listView1);
		staff_cb=(CheckBox) findViewById(R.id.checkBox1);
		mission_cb=(CheckBox) findViewById(R.id.checkBox2);
		place_cb=(CheckBox) findViewById(R.id.checkBox3);
		List<MissionClass> list=new ArrayList<MissionClass>();
		list.add(new MissionClass("فرناز", "اهواز", "94/2/6"));
		list.add(new MissionClass("اکبر", "آبادان", "91/2/6"));
		lv.setAdapter(new ListAdapter(this, list));

	
	}

//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}

//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
//	public static class PlaceholderFragment extends Fragment {
//
//		public PlaceholderFragment() {
//		}
//
//		@Override
//		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//			View rootView = inflater.inflate(R.layout.fragment_main, container, false);
//			return rootView;
//		}
//	}
}
