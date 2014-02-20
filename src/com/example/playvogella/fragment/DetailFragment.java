package com.example.playvogella.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class DetailFragment extends Fragment {
	
	private WebView webView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		webView = new WebView(getActivity());
		return webView;
	}

	public void setText(String item) {
		webView.setInitialScale(50);
		webView.loadUrl(item);
	}
	
	
}
