package com.hipits.regionalinfo.busanfestival.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.hipits.regionalinfo.busanfestival.R;
import com.hipits.regionalinfo.busanfestival.activity.GuideMapActivity;

public class FestivalLocationFragment extends Fragment {
	public static String MSG = null;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_location, null);
		
		View mapViewButton = view.findViewById(R.id.mapViewButton);
		mapViewButton.setBackgroundResource(R.drawable.mapview_btn_selector);
		mapViewButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getActivity(), GuideMapActivity.class);
				intent.putExtra("msg", MSG);
				startActivity(intent);
			}
		});
		showLocation(view);
		return view;
		
	}
	public void showLocation(View view){
		LinearLayout locationImageView = (LinearLayout)view.findViewById(R.id.locationImageView);
		
		if (MSG.equals("port")) {
			locationImageView.setBackgroundResource(R.drawable.festival_3_map_bgpage);
		} else if (MSG.equals("sea")) {
			locationImageView.setBackgroundResource(R.drawable.festival_4_map_bgpage);
		} else if (MSG.equals("flame")) {
			locationImageView.setBackgroundResource(R.drawable.festival_5_map_bgpage);
		} else if (MSG.equals("sun")) {
			locationImageView.setBackgroundResource(R.drawable.festival_1_map_bgpage);
		} else if (MSG.equals("rock")) {
			locationImageView.setBackgroundResource(R.drawable.festival_2_map_bgpage);
		} else {
			Log.d("Debug", "No Message");
		}
	}
	
}
