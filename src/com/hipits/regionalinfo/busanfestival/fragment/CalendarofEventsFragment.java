package com.hipits.regionalinfo.busanfestival.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hipits.regionalinfo.busanfestival.R;

public class CalendarofEventsFragment extends Fragment {

	public static String MSG = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_calendarofevents, null);
		showEvents(view);
		return view;
	}
	public void showEvents(View view){
		
		ImageView eventImageView = (ImageView)view.findViewById(R.id.calendarImageView);
		
		if (MSG.equals("port")) {
			eventImageView.setBackgroundResource(R.drawable.calendar_port);
		} else if (MSG.equals("sea")) {
			eventImageView.setBackgroundResource(R.drawable.calendar_sea);
		} else if (MSG.equals("flame")) {
			eventImageView.setBackgroundResource(R.drawable.calendar_flame);
		} else if (MSG.equals("sun")) {
			eventImageView.setBackgroundResource(R.drawable.calendar_sun);
		} else if (MSG.equals("rock")) {
			eventImageView.setBackgroundResource(R.drawable.calendar_rock);
		} else {
			Log.d("Debug", "No Message");
		}
	}
}
