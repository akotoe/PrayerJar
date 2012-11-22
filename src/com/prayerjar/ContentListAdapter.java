package com.prayerjar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContentListAdapter extends ArrayAdapter<String> {
	private final Context context;
	private final String[] values;
	
	public ContentListAdapter(Context context, String[] values){
		super (context, R.layout.activity_main, values);
		this.context = context;
		this.values = values;
		
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent){
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);			
			View rowView = inflater.inflate(R.layout.list_row, parent, false);
			TextView title = (TextView)rowView.findViewById(R.id.title); // title
	        TextView artist = (TextView)rowView.findViewById(R.id.artist); // artist name
	        TextView duration = (TextView)rowView.findViewById(R.id.duration); // duration
//	        ImageView thumb_image=(ImageView)rowView.findViewById(R.id.list_image); // thumb image
	        
	        
	        artist.setText(values[position]);
	        title.setText("Oh Lord God almighty, ...");
	        artist.setText("Finance");
	        duration.setText("Monday");
//	        thumb_image.setImageResource(R.drawable.ic_launcher);
	        return rowView;
  
	}
}
