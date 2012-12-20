package com.prayerjar;

import java.util.Date;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrayerActivity extends Activity {

	private SQLiteAdapter mySQLiteAdapter;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		mySQLiteAdapter = new SQLiteAdapter(this);
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prayer);
		
		Button btnContinue = (Button)findViewById(R.id.btnClose);
		btnContinue.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startActivity(new Intent(PrayerActivity.this, MainActivity.class));
			
            }
        });
		
		Button btnAnswered = (Button)findViewById(R.id.btnAnswered);
		btnAnswered.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	startActivity(new Intent(PrayerActivity.this, MainActivity.class));
            	mySQLiteAdapter.openToWrite();
            	mySQLiteAdapter.updateValue("Prayed", "answered", getIntent().getExtras().getString("date"));
            	
            	Toast.makeText(getApplicationContext(), "Prayer marked as answered", Toast.LENGTH_LONG).show();
            	mySQLiteAdapter.close();
			
            }
        });
		
		TextView dateView = (TextView)findViewById(R.id.dateView);
		dateView.setText(getIntent().getExtras().getString("date"));
		
		TextView txtPrayer = (TextView)findViewById(R.id.prayerView);
		txtPrayer.setText(getIntent().getExtras().getString("prayer"));
		
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_prayer, menu);
		return true;
	}

}
