package com.hipits.regionalinfo.busanfestival.activity;

import com.hipits.regionalinfo.busanfestival.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class QuizIntroActivity extends Activity {
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quizintro);
		
		View quizStartButton = findViewById(R.id.quizStartButton);
		quizStartButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(QuizIntroActivity.this, QuizActivity.class);
				startActivity(intent);
			}
		});
	}

}
