package com.prayerjar;

import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainScreenV2 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen_v2);
		
		
		
		TextView vwRemainingDays = (TextView) findViewById(R.id.remainingDays);
		vwRemainingDays.setText(getDaysToYearEnd()+" Days Left");
		
		final SQLiteAdapter mySQLiteAdapter = new SQLiteAdapter(this);
		final EditText txtPrayed = (EditText) findViewById(R.id.txtPrayerRequest);
		final EditText txtThanked = (EditText) findViewById(R.id.txtPrayerThanks);
	
		Button btnPrayed = (Button) findViewById(R.id.btnRequestSave);
		btnPrayed.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				if(txtThanked.length() >=1){
					mySQLiteAdapter.openToWrite();	
					mySQLiteAdapter.insert(txtPrayed.getText().toString(),  new Date().toString(),"Prayed" );
					mySQLiteAdapter.close();        
			        Toast.makeText(getApplicationContext(), "Request added", Toast.LENGTH_LONG).show();
				}else{     
			        Toast.makeText(getApplicationContext(), "Please pray first", Toast.LENGTH_LONG).show();
				}
				
			}
			
		});
		
		Button btnThanked = (Button) findViewById(R.id.btnThanksSaved);
		btnThanked.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				if(txtThanked.length() >=1){
					mySQLiteAdapter.openToWrite();	
					mySQLiteAdapter.insert(txtThanked.getText().toString(),  new Date().toString(),"Thanks" );
					mySQLiteAdapter.close();        
			        Toast.makeText(getApplicationContext(), "Thanksgiving added", Toast.LENGTH_LONG).show();
				}else{
					Toast.makeText(getApplicationContext(), "Please pray first", Toast.LENGTH_LONG).show();
				}
				    
		      
			}
			
		});
		
		TextView vwJar = (TextView) findViewById(R.id.jar);
		vwJar.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(MainScreenV2.this, MainActivity.class));
				overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
			}
			
		});
		
		TextView vwSettings = (TextView) findViewById(R.id.vwSettings);
		vwSettings.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				  Toast.makeText(getApplicationContext(), "Settings are disabled", Toast.LENGTH_LONG).show();
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main_screen_v2, menu);
		return true;
	}
	
	public int getDaysToYearEnd(){
		Calendar today = Calendar.getInstance();
		return today.getActualMaximum(Calendar.DAY_OF_YEAR)-today.get(Calendar.DAY_OF_YEAR);
	}

}
