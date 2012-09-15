package com.hipits.regionalinfo.busanfestival.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewDebug.FlagToString;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private Intent intent;
	private Intent quizIntent;
	private ImageView sunImageView;
	private ImageView rockImageView;
	private ImageView portImageView;
	private ImageView flameImageView;
	private ImageView flameImageView2;
	private ImageView seaImageView;
	private int flameFlag;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		sunImageView = (ImageView)findViewById(R.id.sunImageView);
		rockImageView = (ImageView)findViewById(R.id.rockImageView);
		portImageView = (ImageView)findViewById(R.id.portImageView);
		flameImageView = (ImageView) findViewById(R.id.flameImageView);
		flameImageView2 = (ImageView)findViewById(R.id.flameImageView2);
		seaImageView = (ImageView)findViewById(R.id.seaImageView);
		
		sunImageView.setBackgroundResource(R.drawable.sun_btn_selector);
		rockImageView.setBackgroundResource(R.drawable.rock_btn_selector);
		portImageView.setBackgroundResource(R.drawable.port_btn_selector);
		seaImageView.setBackgroundResource(R.drawable.sea_btn_selector);

		intent = new Intent(MainActivity.this, FestivalTabActivity.class);
		
		ImageView quizImageView = (ImageView)findViewById(R.id.quizImageView);
		quizImageView.setBackgroundResource(R.drawable.quiz_btn_selector);
		quizImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				quizIntent = new Intent(MainActivity.this, QuizIntroActivity.class);
				startActivity(quizIntent);
			}
		});

		sunImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("msg", "sun");
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intent);
			}
		});

		rockImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("msg", "rock");
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intent);
			}
		});

		portImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("msg", "port");
				intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
				startActivity(intent);
			}
		});
		
		flameImageView.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent motionEvent) {
				if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {

					flameImageView.setBackgroundResource(R.drawable.main_mouseover_flame1);
					flameImageView2.setBackgroundResource(R.drawable.main_mouseover_flame2);
					return true;
				} else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
					flameImageView.setBackgroundResource(R.drawable.main_flame1);
					flameImageView2.setBackgroundResource(R.drawable.main_flame2);
					intent.putExtra("msg", "flame");
					intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
					startActivity(intent);
					return true;
				}
				return false;
			}
		});

		flameImageView2.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View arg0, MotionEvent motionEvent) {
				if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
					flameImageView.setBackgroundResource(R.drawable.main_mouseover_flame1);
					flameImageView2.setBackgroundResource(R.drawable.main_mouseover_flame2);
					return true;
				} else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
					
					if (flameFlag == 1) {
						flameImageView.setBackgroundResource(R.drawable.main_event_flame1);
						flameImageView2.setBackgroundResource(R.drawable.main_event_flame2);
					} else {
					flameImageView.setBackgroundResource(R.drawable.main_flame1);
					flameImageView2.setBackgroundResource(R.drawable.main_flame2);
					}
					
					intent.putExtra("msg", "flame");
					intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
					startActivity(intent);
					return true;
				}
				return false;
			}
		});

		seaImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("msg", "sea");
				startActivity(intent);
			}
		});

		ImageView characterImageView = (ImageView)findViewById(R.id.characterImageView);
		characterImageView.setBackgroundResource(R.drawable.character_btn_selector);
		characterImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("msg", "character");
			}
		});

		ImageView settingImageView = (ImageView)findViewById(R.id.settingImageView);
		settingImageView.setBackgroundResource(R.drawable.setting_btn_selector);
		settingImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("msg", "setting");
			}
		});
		
		eventImageView();
		
	}
	public void eventImageView() {
		File file = new File(Environment.getExternalStorageDirectory() + "/temp1", "flag.txt");
		
		if (!file.exists()) {
			return;
		}
		
		Scanner scanner = null;
		List<String> datas = new ArrayList<String>();
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			Log.e("File Not found Exception", e.getMessage());
		}
		
		while (scanner.hasNext()) {
			String data = (String) scanner.next();
			datas.add(data);
		}
		
		for (String data : datas) {
			if (data.equals("1")) {
				sunImageView.setBackgroundResource(R.drawable.sun_event_btn_selector);
			} else if(data.equals("2")){
				rockImageView.setBackgroundResource(R.drawable.rock_event_btn_selector);
			} else if (data.equals("3")) {
				portImageView.setBackgroundResource(R.drawable.port_event_btn_selector);
			} else if (data.equals("4")) {
				seaImageView.setBackgroundResource(R.drawable.sea_event_btn_selector);
			} else if (data.equals("5")) {
				flameFlag = 1;
				flameImageView.setBackgroundResource(R.drawable.main_event_flame1);
				flameImageView2.setBackgroundResource(R.drawable.main_event_flame2);
			} 
		}
		scanner.close();
	}
}
