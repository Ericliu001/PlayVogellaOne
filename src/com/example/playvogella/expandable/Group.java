package com.example.playvogella.expandable;

import java.util.ArrayList;
import java.util.List;

public class Group {
	public String string;
	public final List<String> childern = new ArrayList<String>();
	
	public Group(String string){
		this.string = string;
	}
}
