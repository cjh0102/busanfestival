package com.hipits.regionalinfo.busanfestival.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.hipits.regionalinfo.busanfestival.activity.R;

public class FestivalIntroductionFragment extends Fragment{
	
	public static String MSG = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_introduction, null);
		showIntroduction(view);
		return view;
	}
	
	public void showIntroduction(View view) {
		ImageView imageView = (ImageView)view.findViewById(R.id.introductionImageView);
		
		if (MSG.equals("port")) {
			imageView.setBackgroundResource(R.drawable.festival_3_introduction);
		} else if (MSG.equals("sea")) {
			imageView.setBackgroundResource(R.drawable.festival_4_introduction);
		} else if (MSG.equals("flame")) {
			imageView.setBackgroundResource(R.drawable.festival_5_introduction);
		} else if (MSG.equals("sun")) {
			imageView.setBackgroundResource(R.drawable.festival_1_introduction);
		} else if (MSG.equals("rock")) {
			imageView.setBackgroundResource(R.drawable.festival_2_introduction);
		} else {
			Log.d("Debug", "No Message");
		}
	} 
}
