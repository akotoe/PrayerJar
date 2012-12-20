package com.prayerjar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ScreenFive extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_screen_five);
		
		TextView vwNext = (TextView)findViewById(R.id.vwNext);
		vwNext.setOnClickListener(new OnClickListener(){

			public void onClick(View v) {
				// TODO Auto-generated method stub
				startActivity(new Intent(ScreenFive.this, ScreenSix.class ));
				overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
			}
			
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_screen_five, menu);
		return true;
	}

}
