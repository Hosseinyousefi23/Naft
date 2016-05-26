package com.example.naft;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
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
		database.execSQL("CREATE TABLE IF NOT EXISTS Staff(name VARCHAR);");
//		try {
//			Class<?> ourClass = Class.forName("com.example.naft.StaffList");
//			Intent ourIntent = new Intent(MainActivity.this, ourClass);
//			startActivity(ourIntent);
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
		
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
