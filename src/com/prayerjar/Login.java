package com.prayerjar;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;


public class Login extends Activity {
	
	static boolean isKill=false;
	Button btnContinue;
//	Button btnHelp;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(isKill){
			//Toast.makeText(getApplicationContext(), "isKill", Toast.LENGTH_SHORT).show();
			isKill=false;
			finish();
		}else{
			setContentView(R.layout.activity_login);
			//Toast.makeText(getApplicationContext(), "NotisKill", Toast.LENGTH_SHORT).show();
		
		btnContinue = (Button)findViewById(R.id.btnContinue);
		
		btnContinue.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
            	
            	startActivity(new Intent(Login.this, MainScreenV2.class));
            	overridePendingTransition(R.anim.animation_enter, R.anim.animation_leave);
            	
            	
			
            }
        });
		
//		btnHelp = (Button)findViewById(R.id.btnHelp);
//		btnHelp.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
// 
////            	
//            	AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
//            	alertDialog.setTitle("Help");
//            	alertDialog.setMessage("Prayer Jar enables you to create and manage your prayer list. To begin, continue to the home screen and click 'Compose', or visit the online tutorial at www.xyz.com");
//            	alertDialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
//            	    public void onClick(DialogInterface dialog, int id) {
//            	         
//            	    }
//            	});
//            	alertDialog.show();
//
//            }
//        });
//		
			
	}
	}
	@Override
	protected void onResume() {
		super.onResume();
		//Toast.makeText(getApplicationContext(), "Resume Login", Toast.LENGTH_SHORT).show();
		
		
	}
	
	public void onBackPressed() {
		super.onBackPressed();
		super.finish();
		//Toast.makeText(getApplicationContext(), "Application Closed", Toast.LENGTH_SHORT).show();
		isKill=true;
//finish();
		
		
	}
	 
	


}
