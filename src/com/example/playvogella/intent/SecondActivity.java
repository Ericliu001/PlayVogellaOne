package com.example.playvogella.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.playvogella.R;

public class SecondActivity extends Activity {
	
	Intent intent;
	EditText etGotYa;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		
		intent = getIntent();
		Bundle data = intent.getExtras();
		if (data == null) {
			return;
		}
		
		String value1 = data.getString("bastard");
		
		if(value1 != null){
		etGotYa = (EditText) findViewById(R.id.etGotYa);
		etGotYa.setHint(value1);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.second, menu);
		return true;
	}
	
	public void onButtonClicked(View view){
		finish();
	}
	
	@Override
	public void finish() {
		intent = new Intent();
		String yourInput = etGotYa.getText().toString();
		intent.putExtra("returnKey1", yourInput);
		setResult(RESULT_OK, intent);
		super.finish();
	}

}
