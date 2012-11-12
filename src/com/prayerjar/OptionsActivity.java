package com.prayerjar;

import java.text.DateFormat;
import java.util.Calendar;

import android.os.Bundle;
import android.app.Activity;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import android.widget.TextView;
import android.widget.TimePicker;

public class OptionsActivity extends Activity {

    DateFormat fmtTime = DateFormat.getTimeInstance();
	TextView lblTime;
	Calendar myCalendar = Calendar.getInstance();

	
	TimePickerDialog.OnTimeSetListener t = new TimePickerDialog.OnTimeSetListener() {
	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
		myCalendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
		myCalendar.set(Calendar.MINUTE, minute);
		updateLabel();
	}
	};

	private void updateLabel() {
		lblTime.setText(fmtTime.format(myCalendar.getTime()));
	}

	@Override
	public void onCreate(Bundle icicle) {
	super.onCreate(icicle);
	setContentView(R.layout.activity_options);
	lblTime = (TextView) findViewById(R.id.lblTime);
	

	Button btnTime = (Button) findViewById(R.id.btnTime);
	btnTime.setOnClickListener(new View.OnClickListener() {
		public  void onClick(View v) {
			new TimePickerDialog(OptionsActivity.this, t, myCalendar
					.get(Calendar.HOUR_OF_DAY), myCalendar
					.get(Calendar.MINUTE), true).show();
		}
	});
	
	//go to how to options screen
	Button btnNext = (Button)findViewById(R.id.btnNext);
    btnNext.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            // Close the application
        	Intent intent = new Intent(OptionsActivity.this, MainScreenActivity.class);
            startActivity(intent);

        }
    });
    
    Button btnClose = (Button)findViewById(R.id.btnClose);
    btnClose.setOnClickListener(new OnClickListener() {
        public void onClick(View v) {
            finish();
            System.exit(0);

        }
    });


	updateLabel();
	}// onCreate
    
    
    
    
}
