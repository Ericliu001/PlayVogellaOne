package com.example.playvogella.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.SimpleAdapter;

import com.example.playvogella.R;

public class MyTwoListItemsActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ArrayList<Map<String, String>> list = buildData();
		String[] from = {"name" , "purpose"};
		int[] to = { android.R.id.text1, android.R.id.text2};
		
		SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2, from, to);
		setListAdapter(adapter);
	}

	private ArrayList<Map<String, String>> buildData() {
		ArrayList<Map<String, String>> list = new ArrayList<Map<String,String>>();
		list.add(putData("Android", "Mobile"));
		list.add(putData("Windows7", "Windows7"));
		list.add(putData("iPhone", "iPhone"));
		
		return list;
	}

	private Map<String, String> putData(String name, String purpose) {
		HashMap<String, String> item = new HashMap<String, String>();
		item.put("name", name);
		item.put("purpose", purpose);
		return item;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_two_list_items, menu);
		return true;
	}

}
