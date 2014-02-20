package com.example.playvogella.actionbar;

import java.util.Locale;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.playvogella.R;

public class ActionTwoActivity extends Activity implements ActionBar.OnNavigationListener {
	
	
	/**
	 * The serialization (saved instance state) Bundle key representing the current dropdown position
	 */
	private static final String STATE_SELECTED_NAVIGATION_ITEM = "selected_navigation_item";
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_action_two);
	
//		Set up the action bar to show a dropdown list.
		final ActionBar actionBar = getActionBar();
		actionBar.setDisplayShowTitleEnabled(false);
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);
		
		ArrayAdapter<CharSequence> adapter = 
				ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_dropdown_item_1line);
	
		actionBar.setListNavigationCallbacks(adapter, this);
	}
	
	
	@Override
	public boolean onNavigationItemSelected(int itemPosition, long itemId) {
		
		Fragment fragment = new DummySectionFragment();
		Bundle args = new Bundle();
		args.putInt(DummySectionFragment.ARG_SECTION_NUMBER, itemPosition);
		fragment.setArguments(args);
		getFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();
		
		return true;
	}
	
	
	public static class DummySectionFragment extends Fragment {
		
		public static final String ARG_SECTION_NUMBER = "placeholder_text";
		
		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			
			
			View layout = inflater.inflate(R.layout.fragment_planet, container, false);
			ImageView ivImage = (ImageView) layout.findViewById(R.id.ivPlanets);
			
			int i = getArguments().getInt(ARG_SECTION_NUMBER);
			String planet = getResources()
					.getStringArray(R.array.planets_array)[i];
			
			int imageId = getResources().getIdentifier(
					planet.toLowerCase(Locale.getDefault()), "drawable",
					getActivity().getPackageName());

			ivImage.setImageResource(imageId);
			
			return layout;
		
		}
	}
	

}
