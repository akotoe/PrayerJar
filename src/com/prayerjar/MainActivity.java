package com.prayerjar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //go to how to screen
        TextView iv = (TextView)findViewById(R.id.viewHow);
        iv.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Close the application
            	Intent intent = new Intent(MainActivity.this, HowTo.class);
                startActivity(intent);

            }
        });
        
      //go to how to options screen
        TextView options = (TextView)findViewById(R.id.viewStart);
        options.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // Close the application
            	Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    

    
}
