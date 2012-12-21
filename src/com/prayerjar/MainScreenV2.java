package com.prayerjar;

import java.util.Calendar;
import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
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
		
		Toast.makeText(this, ""+getDaysToYearEnd(), Toast.LENGTH_LONG).show();
		
		TextView vwRemainingDays = (TextView) findViewById(R.id.remainingDays);
		vwRemainingDays.setText(getDaysToYearEnd()+" days remaining");
		
		final SQLiteAdapter mySQLiteAdapter = new SQLiteAdapter(this);
//		final EditText txtPrayed = (EditText) findViewById(R.id.prayer);
//		final EditText txtThanked = (EditText) findViewById(R.id.thanks);
//		
//		Button btnPrayed = (Button) findViewById(R.id.btnRequestSave);
//		btnPrayed.setOnClickListener(new OnClickListener(){
//
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				
//				mySQLiteAdapter.openToWrite();	
//				mySQLiteAdapter.insert(txtPrayed.getText().toString(),  new Date().toString(),"Prayed" );
//				mySQLiteAdapter.close();        
//		        Toast.makeText(getApplicationContext(), "Prayer added", Toast.LENGTH_LONG).show();
//			}
//			
//		});
		
//		Button btnThanked = (Button) findViewById(R.id.btnThanksSave);
//		btnThanked.setOnClickListener(new OnClickListener(){
//
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				mySQLiteAdapter.openToWrite();	
//				mySQLiteAdapter.insert(txtThanked.getText().toString(),  new Date().toString(),"Thanks" );
//				mySQLiteAdapter.close();        
//		        Toast.makeText(getApplicationContext(), "Thanksgiving added", Toast.LENGTH_LONG).show();
//			}
//			
//		});
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
