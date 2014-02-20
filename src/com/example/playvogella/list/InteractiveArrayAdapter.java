package com.example.playvogella.list;

import java.util.List;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

import com.example.playvogella.R;

public class InteractiveArrayAdapter extends ArrayAdapter<Model> {
	
	private final List<Model> list;
	private final Activity context;
	
	

	public InteractiveArrayAdapter(Activity context, List<Model> list) {
		super(context, R.layout.rowbuttonlayout, list);
		this.list = list;
		this.context = context;
	}
	
	static class ViewHolder {
		protected TextView text;
		protected CheckBox checkbox;
		protected ViewGroup layout;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		View view = null;
		if (convertView == null) {
			view = context.getLayoutInflater().inflate(R.layout.rowbuttonlayout, null);
			final ViewHolder holder = new ViewHolder();
			holder.text = (TextView) view.findViewById(R.id.label);
			holder.checkbox = (CheckBox) view.findViewById(R.id.check);
			holder.layout = (ViewGroup) view.findViewById(R.id.mylayout);
			
			holder.checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					Model element = (Model) holder.checkbox.getTag();
					element.setSelected(isChecked);
					notifyDataSetChanged();
				}
			});
			
			view.setTag(holder);
			holder.checkbox.setTag(list.get(position));
		}else{
			view = convertView;
			((ViewHolder)view.getTag()).checkbox.setTag(list.get(position));
		}
		ViewHolder holder = (ViewHolder) view.getTag();
		holder.text.setText(list.get(position).getName());
		boolean selected = list.get(position).isSelected();
		holder.checkbox.setChecked(selected);
		if (selected) {
			holder.layout.setBackgroundResource(R.drawable.is_selector_focused);
		}else{
			holder.layout.setBackground(null);
		}
		
		return view;
	}

}
