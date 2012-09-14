package com.hipits.regionalinfo.busanfestival.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class MainActivity extends Activity {
	private Intent intent;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		intent = new Intent(MainActivity.this, FestivalTabActivity.class);
		
		ImageView quizImageView = (ImageView)findViewById(R.id.quizImageView);
		quizImageView.setBackgroundResource(R.drawable.quiz_btn_selector);
		quizImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent = new Intent(MainActivity.this, QuizIntroActivity.class);
				intent.putExtra("msg", "quiz");
				startActivity(intent);
			}
		});
		
		ImageView sunImageView = (ImageView)findViewById(R.id.sunImageView);
		sunImageView.setBackgroundResource(R.drawable.sun_btn_selector);
		sunImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("msg", "sun");
				startActivity(intent);
			}
		});
		
		ImageView rockImageView = (ImageView)findViewById(R.id.rockImageView);
		rockImageView.setBackgroundResource(R.drawable.rock_btn_selector);
		rockImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("msg", "rock");
				startActivity(intent);
			}
		});
		
		final ImageView portImageView = (ImageView)findViewById(R.id.portImageView);
		portImageView.setBackgroundResource(R.drawable.port_btn_selector);
		portImageView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				intent.putExtra("msg", "port");
				startActivity(intent);
			}
		});
		
		final ImageView flameImageView = (ImageView) findViewById(R.id.flameImageView);
		final ImageView flameImageView2 = (ImageView)findViewById(R.id.flameImageView2);
		
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
					flameImageView.setBackgroundResource(R.drawable.main_flame1);
					flameImageView2.setBackgroundResource(R.drawable.main_flame2);
					intent.putExtra("msg", "flame");
					startActivity(intent);
					return true;
				}
				return false;
			}
		});
		
		ImageView seaImageView = (ImageView)findViewById(R.id.seaImageView);
		seaImageView.setBackgroundResource(R.drawable.sea_btn_selector);
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
	}
}
