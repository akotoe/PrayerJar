package com.prayerjar;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class HowTo extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to);
        
        
      //back to home screen
        TextView back = (TextView)findViewById(R.id.viewBack);
        back.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // back to home screen
            	Intent intent = new Intent(HowTo.this, MainActivity.class);
                startActivity(intent);

            }
        });
        
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_how_to, menu);
        return true;
    }
 
}
