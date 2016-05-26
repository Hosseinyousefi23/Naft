package com.example.naft;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListAdapter extends ArrayAdapter<MissionClass> {

	private final Context context;
	private final List<MissionClass> Stafflist;

	public ListAdapter(Context context, List<MissionClass> List) {
		super(context, R.layout.row, List);
		this.context = context;
		this.Stafflist = List;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.row, parent, false);

		TextView name_tv = (TextView) rowView.findViewById(R.id.textView1);
		TextView place_tv = (TextView) rowView.findViewById(R.id.textView2);
		TextView startDate_tv = (TextView) rowView.findViewById(R.id.textView3);
		TextView endDate_tv = (TextView) rowView.findViewById(R.id.textView4);
		TextView duration_tv = (TextView) rowView.findViewById(R.id.textView5);

		name_tv.setText(Stafflist.get(position).getStaffname());
		place_tv.setText(Stafflist.get(position).getPlacename());
		startDate_tv.setText(Stafflist.get(position).getStart_date_mission());
		endDate_tv.setText(Stafflist.get(position).getEnd_date_mission());
		duration_tv.setText(Stafflist.get(position).getDuration_missions()+"");

		return rowView;
	}

}
