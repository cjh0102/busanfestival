package com.hipits.regionalinfo.busanfestival.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class StartActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start);
		final int INTRO_SUCCESS = 1;

		final Handler handler = new Handler() {
			@Override
			public void handleMessage(Message msg) {
				if (msg.what == INTRO_SUCCESS) {
					Intent intent = new Intent(StartActivity.this, MainActivity.class);
					intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
					startActivity(intent);
					finish();
				}
			}

		};        

		final View view = findViewById(R.id.rootView);

		view.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(StartActivity.this, MainActivity.class);
				intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
				startActivity(intent);
				finish();
			}
		});

		new Thread(new Runnable() {
			@Override
			public void run() {
				Animation alphaAnimaiton = AnimationUtils.loadAnimation(StartActivity.this, R.anim.alpha);
				view.startAnimation(alphaAnimaiton);
				try {
					Thread.sleep(2000);
					handler.sendEmptyMessage(INTRO_SUCCESS);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
