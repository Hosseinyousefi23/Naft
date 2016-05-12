package com.example.naft;

import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StaffList extends ListActivity {
	String[] persons;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		SQLiteDatabase database = openOrCreateDatabase("db", MODE_PRIVATE, null);
		Cursor resultSet = database.rawQuery("SELECT name FROM Staff;", null);
		int staffCount = resultSet.getCount();
		persons = new String[staffCount];
		resultSet.moveToFirst();
		for (int i = 0; i < staffCount; i++) {
			persons[i] = resultSet.getString(resultSet.getColumnIndex("name"));
			resultSet.moveToNext();
		}
		super.onCreate(savedInstanceState);

		// TODO read from database and add to arrayList
		setListAdapter(new ArrayAdapter<String>(StaffList.this, android.R.layout.simple_list_item_1, persons));
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		try {
			Class<?> ourClass = Class.forName("com.example.naft.PersonActivity");
			Intent ourIntent = new Intent(StaffList.this, ourClass);
			startActivity(ourIntent);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
