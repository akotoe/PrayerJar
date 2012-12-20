package com.prayerjar;

import java.util.ArrayList;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentListAdapter extends ArrayAdapter<PrayerItem> {
	private final Context context;
	private final ArrayList<PrayerItem> values;
	
	public ContentListAdapter(Context context, ArrayList<PrayerItem> prayerItems){
		super (context, R.layout.activity_main, prayerItems);
		this.context = context;
		this.values = prayerItems;
		
		
		//startActivity(new Intent(this, AddActivity.class));
		
	}
	
	@Override
	public View getView(final int position, View convertView, ViewGroup parent){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);			
			View rowView = inflater.inflate(R.layout.list_row, parent, false);
			TextView prayer = (TextView)rowView.findViewById(R.id.prayer); // title
	        TextView date = (TextView)rowView.findViewById(R.id.date); // artist name
	        TextView answered = (TextView)rowView.findViewById(R.id.answered); // duration
//	        ImageView thumb_image=(ImageView)rowView.findViewById(R.id.list_image); // thumb image
	        
	        
	        //artist.setText(values.get(position).prayer);
//	        prayer.setText(values.get(position).prayer);
	        if(values.get(position).prayer.length() >=20){
	        	prayer.setText(values.get(position).prayer.subSequence(0, 19)+" ...");
	        }else{
	        	prayer.setText(values.get(position).prayer);
	        }
	        
	        date.setText(values.get(position).date);
	        answered.setText(values.get(position).answered);
	      
	        
	        
	        return rowView;
  
	}
}
