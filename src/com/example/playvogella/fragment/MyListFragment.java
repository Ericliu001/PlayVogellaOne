package com.example.playvogella.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.playvogella.R;

public class MyListFragment extends Fragment {
	private OnItemSelectedListener listener;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.fragment_rsslist_overview, container, false);
		Button bt1 = (Button) view.findViewById(R.id.btUpdate);
		bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				updataDetail();
			}
		});
		
		
		return view;
	}
	
	public interface OnItemSelectedListener{
		public void onRssItemSelected(String link);
	}
	
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		if (activity instanceof OnItemSelectedListener) {
			listener = (OnItemSelectedListener)activity;
		}else{
			throw new ClassCastException(activity.toString()
					+ " must implement MyListFragment.OnItemSelectedListener.");
		}
	}

	protected void updataDetail() {
		// Create a string, just for testing
		String newTime = String.valueOf(System.currentTimeMillis());
		
		listener.onRssItemSelected(newTime);
	}
	
}
