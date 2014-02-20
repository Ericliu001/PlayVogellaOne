package com.example.playvogella.list;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.playvogella.R;

public class MyPerformanceAdapter extends ArrayAdapter<String> {
	
	private final Activity context;
	private final String[] names;
	
	static class ViewHolder{
		public TextView text;
		public ImageView image;
	}

	public MyPerformanceAdapter(Activity context,  String[] objects) {
		super(context, R.layout.rowlayout , objects);
		this.context = context;
		this.names = objects;
	}
	
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View rowView = convertView;
		if (rowView == null) {
			LayoutInflater inflater = context.getLayoutInflater();
			rowView = inflater.inflate(R.layout.rowlayout, null);
			ViewHolder viewHolder = new ViewHolder();
			viewHolder.text = (TextView) rowView.findViewById(R.id.label);
			viewHolder.image = (ImageView) rowView.findViewById(R.id.icon);
			rowView.setTag(viewHolder);
		}
		
		ViewHolder holder = (ViewHolder) rowView.getTag();
		String s = names[position];
		holder.text.setText(s);
		
		if (s.startsWith("iPhone")) {
			holder.image.setImageResource(R.drawable.no);
		}else{
			holder.image.setImageResource(R.drawable.ok);
		}
		
		return rowView;
	}

}
