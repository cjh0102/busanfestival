package com.hipits.regionalinfo.busanfestival.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

import com.hipits.regionalinfo.busanfestival.R;

public class CharacterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character);
		ImageView cartoonImageView = (ImageView)findViewById(R.id.cartoonImageView);
		
		if (isEvent()) {
			//이벤트가 일어났을때
		} else {
			//이벤트가 일어 나지 않았을때.
		}

	}
	public Boolean isEvent() {
		File file = new File(Environment.getExternalStorageDirectory() + "/temp1", "flag.txt");
		
		if (!file.exists()) {
			return false;
		}

		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String[] data = reader.readLine().split("\t");

			if (data.length == 5) {
				return true;
			}
			reader.close();
		} catch (Exception e) {
			Log.e("Exception", e.getMessage());
		}
		return false;
	}
}
