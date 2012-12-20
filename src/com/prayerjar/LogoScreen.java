package com.prayerjar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
//import android.widget.Toast;
import android.widget.Toast;


public class LogoScreen extends Activity{
	
	private final long startTime = 1000;
	private final long interval = 1000;
	private Timer timer= new Timer(startTime, interval);
	
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.logo_screen_activity);
		timer.start();
	 //Toast.makeText(getApplicationContext(), "Welcome", Toast.LENGTH_SHORT).show();
			
	}

	public void onResume(){
		super.onResume();
		timer.start();
				
	}
	public void onBackPressed() {
		super.onBackPressed();
		timer.cancel();
		this.finish();
		
	}	
	private void nextActivity(){
		startActivity(new Intent(LogoScreen.this, MainActivity.class));
		this.finish();		
	}
	private class Timer extends CountDownTimer{	
		public Timer(long startTime, long interval){
			super(startTime, interval);	
		}
		@Override
		public void onFinish() {
			nextActivity(); 	
		}
		@Override
		public void onTick(long millisUntilFinished) {		
		}
	}
}
