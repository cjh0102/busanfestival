package com.hipits.regionalinfo.busanfestival.activity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.hipits.regionalinfo.busanfestival.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class QuizActivity extends Activity implements OnClickListener{
	private Map<String, String> map;
	private EditText sunEditText;
	private EditText rockEditText;
	private EditText portEditText;
	private EditText seaEditText;
	private EditText flameEditText;
	private View v15;
	private View v16;
	private View v17;
	private View v18;
	private View v19;
	private View imagev;
	private LinearLayout linl;
	
	int count = 0;

	File path;
	File file;
	FileWriter writer;

	int[] overlap = new int[5];

	Intent intent;

	String[] strs = new String[]{"", "", "", "",""};
	String[] overlab = new String[]{"", "", "", "", ""};

	AlertDialog.Builder alert;


	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_quiz);
		
		alert = new AlertDialog.Builder(this); 

		path = new File(Environment.getExternalStorageDirectory() + "/temp1");
		if (!path.exists()) {
			path.mkdirs();
		}

		file = new File(path, "flag.txt");

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try{
			writer = new FileWriter(file, true);

			BufferedReader br = new BufferedReader(new FileReader(Environment.getExternalStorageDirectory()
					+ "/temp1/flag.txt")); 
			strs = br.readLine().split("\t");       	   
			br.close();
			

		}catch(Exception e){
			
		} 

		for(int i = 0; i < strs.length; i++)
		{
			if(strs[i].equals("1"))
				overlab[0] = "1";
			else if (strs[i].equals("2"))
				overlab[1] = "2";
			else if (strs[i].equals("3"))
				overlab[2] = "3";
			else if (strs[i].equals("4"))
				overlab[3] = "4";
			else if (strs[i].equals("5"))
				overlab[4] = "5";
		}
		
		map = new HashMap<String, String>();
		map.put("1", "용두산");
		map.put("2", "부활");
		map.put("3", "나제즈다");
		map.put("4", "윈드서핑");
		map.put("5", "나이아가라");


		sunEditText = (EditText) findViewById(R.id.sunEditText);
		rockEditText = (EditText) findViewById(R.id.rockEditText);
		portEditText = (EditText) findViewById(R.id.portEditText);
		seaEditText = (EditText) findViewById(R.id.seaEditText);
		flameEditText = (EditText) findViewById(R.id.flameEditText);

		v15 = (View)findViewById(R.id.view15);
		v16 = (View)findViewById(R.id.view16);
		v17 = (View)findViewById(R.id.view17);
		v18 = (View)findViewById(R.id.view18);
		v19 = (View)findViewById(R.id.view19);
		imagev = (View)findViewById(R.id.imageView);
		linl = (LinearLayout)findViewById(R.id.LinearLayout1);

		v15.setOnClickListener(this);
		v16.setOnClickListener(this);
		v17.setOnClickListener(this);
		v18.setOnClickListener(this);
		v19.setOnClickListener(this);
		imagev.setOnClickListener(this);


		sunEditText.setVisibility(View.VISIBLE);
		portEditText.setVisibility(View.INVISIBLE);
		seaEditText.setVisibility(View.INVISIBLE);
		rockEditText.setVisibility(View.INVISIBLE);
		flameEditText.setVisibility(View.INVISIBLE);
		linl.setBackgroundResource(R.drawable.festival_1_introduction2);
		v15.setBackgroundResource(R.drawable.quiz_undertapbtn_mouseover_1);
		v16.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_2);
		v17.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_3);
		v18.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_4);
		v19.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_5);
		count = 1;

	}
	
	@Override
	public void onClick(View v) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(Environment.getExternalStorageDirectory()
					+ "/temp1/flag.txt")); 
			strs = br.readLine().split("\t");  
			br.close();
			
		}catch(Exception e){

		}
		
		if((v.getId()==R.id.view15)){
			v15.setBackgroundResource(R.drawable.quiz_undertapbtn_mouseover_1);
			v16.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_2);
			v17.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_3);
			v18.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_4);
			v19.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_5);
			sunEditText.setVisibility(View.VISIBLE);
			portEditText.setVisibility(View.INVISIBLE);
			seaEditText.setVisibility(View.INVISIBLE);
			rockEditText.setVisibility(View.INVISIBLE);
			flameEditText.setVisibility(View.INVISIBLE);
			linl.setBackgroundResource(R.drawable.festival_1_introduction2);
			count = 1;
	
		}
		else if(v.getId()==R.id.view16){
			v15.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_1);
			v16.setBackgroundResource(R.drawable.quiz_undertapbtn_mouseover_2);
			v17.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_3);
			v18.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_4);
			v19.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_5);
			sunEditText.setVisibility(View.INVISIBLE);
			portEditText.setVisibility(View.INVISIBLE);
			seaEditText.setVisibility(View.INVISIBLE);
			rockEditText.setVisibility(View.VISIBLE);
			flameEditText.setVisibility(View.INVISIBLE);
			linl.setBackgroundResource(R.drawable.festival_2_introduction2);
			count = 2;
		}
		else if(v.getId()==R.id.view17){
			v15.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_1);
			v16.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_2);
			v17.setBackgroundResource(R.drawable.quiz_undertapbtn_mouseover_3);
			v18.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_4);
			v19.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_5);
			sunEditText.setVisibility(View.INVISIBLE);
			portEditText.setVisibility(View.VISIBLE);
			seaEditText.setVisibility(View.INVISIBLE);
			rockEditText.setVisibility(View.INVISIBLE);
			flameEditText.setVisibility(View.INVISIBLE);
			linl.setBackgroundResource(R.drawable.festival_3_introduction2);
			count = 3;
		}	
		else if(v.getId()==R.id.view18){
			v15.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_1);
			v16.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_2);
			v17.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_3);
			v18.setBackgroundResource(R.drawable.quiz_undertapbtn_mouseover_4);
			v19.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_5);
			sunEditText.setVisibility(View.INVISIBLE);
			portEditText.setVisibility(View.INVISIBLE);
			seaEditText.setVisibility(View.VISIBLE);
			rockEditText.setVisibility(View.INVISIBLE);
			flameEditText.setVisibility(View.INVISIBLE);
			linl.setBackgroundResource(R.drawable.festival_4_introduction2);
			count = 4;
		}	
		else if(v.getId()==R.id.view19){
			v15.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_1);
			v16.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_2);
			v17.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_3);
			v18.setBackgroundResource(R.drawable.quiz_undertapbtn_normal_4);
			v19.setBackgroundResource(R.drawable.quiz_undertapbtn_mouseover_5);
			sunEditText.setVisibility(View.INVISIBLE);
			portEditText.setVisibility(View.INVISIBLE);
			seaEditText.setVisibility(View.INVISIBLE);
			rockEditText.setVisibility(View.INVISIBLE);
			flameEditText.setVisibility(View.VISIBLE);
			linl.setBackgroundResource(R.drawable.festival_5_introduction2);
			count = 5;
		}

		if(v.getId() == R.id.imageView){
			if(count == 1){
				if(isCoreect("1", sunEditText.getText().toString())){
					if(overlap[0] == 1)
						Toast.makeText(this, "That's right", Toast.LENGTH_LONG).show();
					else
					{
						if(overlab[0].equals("1")) {
							alert.setTitle("!!");
							alert.setMessage("이미 퀴즈를 풀었습니다");
							alert.setPositiveButton("닫기", new DialogInterface.OnClickListener() {							
								public void onClick(DialogInterface dialog, int which) {										
								}
							});
							alert.show();
							
						}else {
							intent = new Intent(this, MainActivity.class);
							try{
								alert.setTitle("정답");
								alert.setMessage("퀴즈를 맞추셨습니다!!");
								alert.setPositiveButton("이벤트 보러 가기", new DialogInterface.OnClickListener() {							
									public void onClick(DialogInterface dialog, int which) {	
										intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
										startActivity(intent);
									}
								});
								alert.show();
								writer.write("1" + "\t");
								writer.flush(); 	
							}catch(Exception e){}
							overlap[0] = 1;
						}	         
					}
				} else if (sunEditText.getText().toString().length() == 0) {
					Toast.makeText(this, "답을 적으세요~~", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(this, "답이 틀렸습니다", Toast.LENGTH_LONG).show();
				}
			}
			if(count == 2){
				if(isCoreect("2", rockEditText.getText().toString())){
					if(overlap[1] == 2)
						Toast.makeText(this, "That's right", Toast.LENGTH_LONG).show();
					else
					{
						if(overlab[1].equals("2"))
						{
							alert.setTitle("!!");
							alert.setMessage("이미 퀴즈를 풀었습니다");
							alert.setPositiveButton("닫기", new DialogInterface.OnClickListener() {							
								public void onClick(DialogInterface dialog, int which) {								
								}
							});
							alert.show();
						}
						else
						{
							intent = new Intent(this, MainActivity.class);
							try{
								alert.setTitle("정답");
								alert.setMessage("퀴즈를 맞추셨습니다!!");
								alert.setPositiveButton("이벤트 보러 가기", new DialogInterface.OnClickListener() {							
									public void onClick(DialogInterface dialog, int which) {
										intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
										startActivity(intent);
										finish();
									}
								});
								alert.show();

								writer.write("2" + "\t");
								writer.flush(); 
							}catch(Exception e){}
							overlap[1] = 2;
						}	         
					}
				} else if (rockEditText.getText().toString().length() == 0) {
					Toast.makeText(this, "답을 적으세요~~", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(this, "답이 틀렸습니다", Toast.LENGTH_LONG).show();
				}
			}
			if(count == 3){
				if(isCoreect("3", portEditText.getText().toString())){
					if(overlap[2] == 3)
						Toast.makeText(this, "That's right", Toast.LENGTH_LONG).show();
					else
					{
						if(overlab[2].equals("3"))
						{
							alert.setTitle("!!");
							alert.setMessage("이미 퀴즈를 풀었습니다");
							alert.setPositiveButton("닫기", new DialogInterface.OnClickListener() {							
								public void onClick(DialogInterface dialog, int which) {								
								}
							});
							alert.show();
						}
						else
						{
							intent = new Intent(this, MainActivity.class);
							try{
								alert.setTitle("정답");
								alert.setMessage("퀴즈를 맞추셨습니다!!");
								alert.setPositiveButton("이벤트 보러 가기", new DialogInterface.OnClickListener() {							
									public void onClick(DialogInterface dialog, int which) {
										intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
										startActivity(intent);

										finish();
									}
								});
								alert.show();
								writer.write("3" + "\t");
								writer.flush(); 	
							}catch(Exception e){}
							overlap[2] = 1;
						}	         
					}
				} else if (portEditText.getText().toString().length() == 0) {
					Toast.makeText(this, "답을 적으세요~~", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(this, "답이 틀렸습니다.", Toast.LENGTH_LONG).show();
				}
			}
			if(count == 4){
				if(isCoreect("4", seaEditText.getText().toString())){
					if(overlap[3] == 4)
						Toast.makeText(this, "That's right", Toast.LENGTH_LONG).show();
					else
					{
						if(overlab[3].equals("4"))
						{
							alert.setTitle("!!");
							alert.setMessage("이미 퀴즈를 풀었습니다");
							alert.setPositiveButton("닫기", new DialogInterface.OnClickListener() {							
								public void onClick(DialogInterface dialog, int which) {								
								}
							});
							alert.show();
						}
						else
						{
							intent = new Intent(this, MainActivity.class);
							try{
								alert.setTitle("정답");
								alert.setMessage("퀴즈를 맞추셨습니다!!");
								alert.setPositiveButton("이벤트 보러 가기", new DialogInterface.OnClickListener() {							
									public void onClick(DialogInterface dialog, int which) {
										intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
										startActivity(intent);
										finish();
									}
								});
								alert.show();
								writer.write("4" + "\t");
								writer.flush(); 
							}catch(Exception e){}
							overlap[3] = 4;
						}	         
					}
				} else if (seaEditText.getText().toString().length() == 0) {
					Toast.makeText(this, "답을 적으세요~~", Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(this, "답이 틀렸습니다", Toast.LENGTH_LONG).show();
				}
			}

			if(count == 5){
				if(isCoreect("5", flameEditText.getText().toString())){
					if(overlap[4] == 5)
						Toast.makeText(this, "That's right", Toast.LENGTH_LONG).show();
					else
					{
						if(overlab[4].equals("5"))
						{
							alert.setTitle("!!");
							alert.setMessage("이미 퀴즈를 풀었습니다");
							alert.setPositiveButton("닫기", new DialogInterface.OnClickListener() {							
								public void onClick(DialogInterface dialog, int which) {								
								}
							});
							alert.show();
						}
						else							
						{
							intent = new Intent(this, MainActivity.class);
							try{
								alert.setTitle("정답");
								alert.setMessage("퀴즈를 맞추셨습니다!!");
								alert.setPositiveButton("이벤트 보러 가기", new DialogInterface.OnClickListener() {							
									public void onClick(DialogInterface dialog, int which) {
										intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
										startActivity(intent);
										finish();
									}
								});
								alert.show();
								writer.write("5" + "\t");
								writer.flush(); 									
							}catch(Exception e){}
							overlap[4] = 5;
						}	         
					}
				} else if (flameEditText.getText().toString().length() == 0) {
					Toast.makeText(this, "답을 적으세요~~", Toast.LENGTH_LONG).show();
				}
				else{
					Toast.makeText(this, "답이 틀렸습니다", Toast.LENGTH_LONG).show();
				}
			}
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		try{
			writer.flush();
			writer.close();
		}catch(Exception e){;}
	}

	public Boolean isCoreect(String number,String answer) {
		if(map.get(number).equals(answer)) {
			return true;
		}
		return false;
	}
}
