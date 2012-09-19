package com.hipits.regionalinfo.busanfestival.activity;

import java.io.File;
import java.io.FileWriter;
import java.nio.channels.AlreadyConnectedException;
import java.util.Date;

import com.hipits.regionalinfo.busanfestival.R;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;

public class ETCActivity extends Activity implements OnClickListener{

	File file;
	File path;
	Intent intent;
	AlertDialog.Builder alert;
	View Cbutton;
	View Dbutton;
	View Abutton;
	
	static String ALARM_STATE = "OFF";
	
	public void init(){

		Cbutton = (View)findViewById(R.id.CleanButton);
		Dbutton = (View)findViewById(R.id.DoneButton);
		Abutton = (View)findViewById(R.id.AlamButton);

		Cbutton.setBackgroundResource(R.drawable.cleanmain_btn_selector);
		Dbutton.setBackgroundResource(R.drawable.donemain_btn_selector);
		
		if (ALARM_STATE.equals("OFF")) {
			Abutton.setBackgroundResource(R.drawable.setting_btn_mouseover_17);
		} else {
			Abutton.setBackgroundResource(R.drawable.setting_btn_normal_17);
		}
		
		alert = new AlertDialog.Builder(this);

		Cbutton.setOnClickListener(this);
		Dbutton.setOnClickListener(this);
		Abutton.setOnClickListener(this);
		
		path = new File(Environment.getExternalStorageDirectory() + "/temp1");
		
		if (!path.exists()) {
			path.mkdir();
		}
		
		file = new File(path, "flag.txt");
		intent = new Intent(ETCActivity.this, MainActivity.class);
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_etc);

		init();
		
	}

	public void onClick(View v){
		if(v.getId() == R.id.CleanButton)  
		{
			alert.setTitle("알림");
			alert.setMessage("메인화면을초기화 하시겠습니까?");
			alert.setPositiveButton("네", new DialogInterface.OnClickListener() {

				public void onClick(DialogInterface dialog, int which) {
					try{
						if (file.exists()) {
							file.delete();
						}
					} catch(Exception e){

					}
					startActivity(intent);
					finish();
				}
			}).setNegativeButton("아니오", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			alert.show();    		
		}

		else if(v.getId() == R.id.DoneButton)
		{
			alert.setTitle("알림");
			alert.setMessage("완성된 화면을 보시겠습니까?");
			alert.setPositiveButton("네", new DialogInterface.OnClickListener() {				
				public void onClick(DialogInterface dialog, int which) {
					try{
						if(file.exists()){
							file.delete();
						}
						file.createNewFile();
						
						FileWriter writer = new FileWriter(file, true);
						writer.write("1" + "\t" + "2" + "\t" + "3" + "\t" + "4" + "\t" + "5" + "\t");
						writer.flush();
						writer.close();
					} catch(Exception e){

					}
					startActivity(intent);
					finish();
				}
			}).setNegativeButton("아니오", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
				}
			});
			alert.show();
		}

		else if(v.getId() == R.id.AlamButton)
		{
			alert.setTitle("알람");
			alert.setMessage("다음축제알람기능");
			alert.setPositiveButton("켜기", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int which) {
					ALARM_STATE = "ON";
					Abutton.setBackgroundResource(R.drawable.setting_btn_normal_17);
					startActivity(intent);
				}
			}).setNegativeButton("끄기", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					ALARM_STATE = "OFF";
					Abutton.setBackgroundResource(R.drawable.setting_btn_mouseover_17);
					startActivity(intent);
				}
			});
			alert.show();
		}
	}
}
