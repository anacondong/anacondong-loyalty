package com.loyalty.myapp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class T1 {

	
	
	public static void main(String[] args) {

		String startDateString = "2014-06-11";
	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd"); 
	    
	    Date startDate;
	    try {
	        startDate = df.parse(startDateString);
	        String newDateString = df.format(startDate);
	        System.out.println(newDateString);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}
}
