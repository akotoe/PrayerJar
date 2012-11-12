package com.prayerjar;

import android.os.Bundle;
import android.app.Activity;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainScreenActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        
        
      //go to how to options screen
    	Button btnClose = (Button)findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            	finish();
                System.exit(0);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_screen, menu);
        return true;
    }
    
    
}
