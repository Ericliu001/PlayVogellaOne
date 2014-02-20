package com.example.playvogella.expandable;

import com.example.playvogella.R;

import android.os.Bundle;
import android.app.Activity;
import android.util.SparseArray;
import android.view.Menu;
import android.widget.ExpandableListView;

public class ExpandableActivity extends Activity {
	
	SparseArray<Group> groups = new SparseArray<Group>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expandable);
        
        createData();
        ExpandableListView listView = (ExpandableListView) findViewById(R.id.lvExpandable);
        MyExpandableListAdapter adapter = new MyExpandableListAdapter(this, groups);
        listView.setAdapter(adapter);
    }


    private void createData() {
    	for (int j = 0; j < 5; j++) {
			Group group = new Group("Test " + j );
			for (int i = 0; i < 5; i++) {
				group.childern.add("Sub Item " + i);
			}
			groups.append(j, group);
		}
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.expandable, menu);
        return true;
    }
    
}
