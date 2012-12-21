package com.prayerjar;


import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import android.os.Bundle;
import android.text.format.Time;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity{
	static boolean isKill = false;
	
	
	private SQLiteAdapter mySQLiteAdapter;
	ListView listView;
	final ArrayList<PrayerItem> prayerItems = new ArrayList<PrayerItem>(); 
	
	ContentListAdapter adapter;
	
	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(isKill){
			isKill = false;
			finish();	
		}else{
		setContentView(R.layout.activity_main);
		
		final TextView composeView = (TextView) findViewById(R.id.vwCompose);
		composeView.setOnClickListener(new OnClickListener() {

		    public void onClick(View v) {
		        // TODO Auto-generated method stub
		       
		        	startActivity(new Intent(MainActivity.this, MainScreenV2.class));
		        	overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
		       
		    }
		});
		
		
		listView = (ListView) findViewById(R.id.list);
		
		loadListViewData();
		
		listView.setOnItemClickListener(new OnItemClickListener(){

			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				
				Intent whatsOnItemDetailsIntent = new Intent(MainActivity.this, PrayerActivity.class);
				

                whatsOnItemDetailsIntent.putExtra("prayer", prayerItems.get(position).prayer);
                whatsOnItemDetailsIntent.putExtra("date", prayerItems.get(position).date);
                whatsOnItemDetailsIntent.putExtra("answered", prayerItems.get(position).answered);
                
                startActivity(whatsOnItemDetailsIntent);
				
				
			}
			
		});
		
		listView.setOnItemLongClickListener(new OnItemLongClickListener(){
			
			
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					final int position, long arg3) {
				// TODO Auto-generated method stub

            	AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
            	alertDialog.setTitle("Choose action");
            	alertDialog.setMessage(prayerItems.get(position).prayer);
            	alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "Delete", new DialogInterface.OnClickListener() {
            	    public void onClick(DialogInterface dialog, int id) {
            	     mySQLiteAdapter.openToRead();
       				 mySQLiteAdapter.delete_byRow(prayerItems.get(position).date);
       				
       				 mySQLiteAdapter.close();
       				 
       				 
       				
       				loadListViewData();
            	    }
            	});
            	
            	alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            	    public void onClick(DialogInterface dialog, int id) {
            	     
            	    }
            	});
            	
            	alertDialog.show();
				 
				return false;
			}
			
		});
		
		
		
		
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.jar_menu, menu);
	    return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		
		switch (item.getItemId()){
			
			
			case R.id.settings:	
				startActivity(new Intent(this, SettingsActivity.class));
				return true;
			}
		
			return false;
		
		}

	@Override
	protected void onResume() {
		super.onResume();
//		Toast.makeText(getApplicationContext(), "Resume Login", Toast.LENGTH_SHORT).show();
		
		
	}
	
	public void onBackPressed() {
		//super.onBackPressed();
		
		mySQLiteAdapter.close();
//		Toast.makeText(getApplicationContext(), "Application Closed", Toast.LENGTH_SHORT).show();
		isKill=true;
		finish();
		
		
	}
	
	public void loadListViewData(){
		
		adapter = new ContentListAdapter(this, prayerItems);
		adapter.clear();
		adapter.notifyDataSetChanged();
		
		
		listView.setAdapter(null);
		
		
		
        mySQLiteAdapter = new SQLiteAdapter(this);
        mySQLiteAdapter.openToRead();
       
        
        
        Cursor cursor = mySQLiteAdapter.queueAll();
       
      
       
        cursor.moveToFirst();
        
        for (int i =0; i<cursor.getCount(); i++){
        	PrayerItem prayerItem= new PrayerItem();
        	prayerItem.prayer = cursor.getString( 0);
    		prayerItem.date = (cursor.getString(1));
    		prayerItem.answered = (cursor.getString(2));
    		prayerItems.add(prayerItem);
    		
        	cursor.moveToNext();
        }
       
      
        mySQLiteAdapter.close();
	
		
		
		
		listView.setAdapter(adapter); 
		

	}
    
    
}