package com.example.playvogella.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.playvogella.R;

public class FirstActivity extends Activity {
	private static final int REQUEST_CODE = 12;
	
	TextView tvResult;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intent);
		
		tvResult = (TextView) findViewById(R.id.tvResult);
		Button btStartActivity = (Button) findViewById(R.id.btStartActivity);
		btStartActivity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(FirstActivity.this, SecondActivity.class);
				intent.putExtra("bastard", "Eric is awesome");
				startActivityForResult(intent,  REQUEST_CODE);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.intent, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
			String returnValue = data.getExtras().getString("returnKey1");
			tvResult.setText(returnValue);
		}
	
	}

}
