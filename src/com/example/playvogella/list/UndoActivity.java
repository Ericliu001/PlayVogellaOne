package com.example.playvogella.list;

import com.example.playvogella.R;
import com.example.playvogella.R.layout;
import com.example.playvogella.R.menu;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class UndoActivity extends Activity {
	
	private View viewContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_undo);
		
		ListView list = (ListView) findViewById(R.id.listview);
		String[] values = new String[] { "Ubuntu", "Android", "iPhone",
				"Windows", "Ubuntu", "Android", "iPhone", "Windows" };
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, values);
		list.setAdapter(adapter);
		viewContainer = findViewById(R.id.undobar);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.undo, menu);
		return true;
	}
	
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		showUndo(viewContainer);
		
		return true;
	}
	
	public void onClick(View view) {
		Toast.makeText(this, "Deletion undone", Toast.LENGTH_LONG).show();
		viewContainer.setVisibility(View.GONE);
	}

	public static void showUndo(final View viewContainer) { // only final variables are accessible in anonymous class
		viewContainer.setVisibility(View.VISIBLE);
		viewContainer.setAlpha(1);
		viewContainer.animate().alpha(0.4f).setDuration(5000).withEndAction(new Runnable() {
			
			@Override
			public void run() {
				viewContainer.setVisibility(View.GONE);
			}
		});
	}

}
