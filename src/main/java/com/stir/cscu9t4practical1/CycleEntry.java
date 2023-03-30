package com.stir.cscu9t4practical1;

public class CycleEntry extends Entry {

	public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist) {
		super(n, d,m, y, h, min, s, dist);
	}
	
	public String getEntry() { // changes the activity name in the result string
		String result = getName()+ " cycled " + getDistance() + " km in " +getHour()+":"+getMin()+":"+ getSec() + " on " + getDay()+ "/" + getMonth() + "/" + getYear()+ "\n";
		return result;
	}
}
