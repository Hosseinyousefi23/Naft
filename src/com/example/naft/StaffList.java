package com.example.naft;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StaffList extends ListActivity {
	String[] persons = { "dastan", "cheese" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
