package com.prayerjar;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

public class MainActivity extends Activity{
	static boolean isKill = false;
	static final String[] CONTENT = new String[]{"Android", "iOS", "WindowsMobile", "Blackberry"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(isKill){
			isKill = false;
			finish();	
		}else{
		setContentView(R.layout.activity_main);
		
		ListView listView = (ListView) findViewById(R.id.list);
		String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
		  "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
		  "Linux", "OS/2" };
	
		ContentListAdapter adapter = new ContentListAdapter(this, values);
		// Assign adapter to ListView
		listView.setAdapter(adapter); 
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
	    MenuInflater inflater = getMenuInflater();
	    inflater.inflate(R.menu.jar_menu, menu);
	    return true;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
//		Toast.makeText(getApplicationContext(), "Resume Login", Toast.LENGTH_SHORT).show();
		
		
	}
	
	public void onBackPressed() {
		//super.onBackPressed();
//		Toast.makeText(getApplicationContext(), "Application Closed", Toast.LENGTH_SHORT).show();
		isKill=true;
		finish();
		
		
	}
    
    
}