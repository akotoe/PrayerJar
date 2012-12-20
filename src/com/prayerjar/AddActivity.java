package com.prayerjar;

import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AddActivity extends Activity{
	
	
	private SQLiteAdapter mySQLiteAdapter;
	
	
	public void onCreate(Bundle savedInstanceState){
		Button btnAddAmen;
		Button btnPrayerClear;
		Button btnPrayerCancel;
		
		
		final TextView txtPrayer;
		String[] countries = getResources().getStringArray(R.array.tags);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_activity);
		
		mySQLiteAdapter = new SQLiteAdapter(this);
		btnPrayerClear = (Button)findViewById(R.id.btnPrayerClear);
		txtPrayer = (TextView)findViewById(R.id.prayer);
		btnAddAmen = (Button)findViewById(R.id.btnAddAmen);
		btnPrayerCancel = (Button)findViewById(R.id.btnPrayerCancel);
		String stAnswer = "wait";
		btnAddAmen.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View arg0) {
				if(txtPrayer.length() >=1){
					
			        mySQLiteAdapter.openToWrite();
	        
			      
			        mySQLiteAdapter.insert(txtPrayer.getText().toString(),  new Date().toString(),"Prayed" );
			       
			       
			        mySQLiteAdapter.close();
			        
			        Toast.makeText(getApplicationContext(), "Prayer added", Toast.LENGTH_LONG).show();

					startActivity(new Intent(getApplicationContext(), MainActivity.class));
					
				}else{
					 Toast.makeText(getApplicationContext(), "Please pray first", Toast.LENGTH_LONG).show();
				}
				
				
			}
			
			
		
	});
		
	
		btnPrayerClear.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View arg0) {
				txtPrayer.setText("");
				
			}
			
			
			
		
	});
		
		btnPrayerCancel.setOnClickListener(new Button.OnClickListener(){

			public void onClick(View arg0) {
				
				startActivity(new Intent(getApplicationContext(), MainActivity.class));
			}
		
		
		});
	
	}
	
	
}

