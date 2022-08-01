package com.letskodeit.utilities;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class testt {

	public static void main(String[] args) {
		StringBuilder sbuilder = new StringBuilder();
		String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i = 0; i < 5; i++) {
			int index = (int) (Math.random() * chars.length());
			sbuilder.append(chars.charAt(index));
			

	}System.out.println(sbuilder.toString());
	System.out.println(System.getProperty("os.name").toLowerCase().substring(0, 3));
	System.out.println(System.getProperty("user.dir"));
	
	String name ="dhanushka";
	
	System.out.println(name.length()==9?"yes":"false");
	
	//////////////////
	
	
	   StringBuilder names = new StringBuilder();
	   
	            names.append("AutomationReport_")
	            .append(getDate())
	            .append(".html");
	    System.out.println(names.toString());
	
	}
	public static String getDate() {
	Calendar currentDate = Calendar.getInstance();
    SimpleDateFormat formatter = new SimpleDateFormat(
            "MM/dd/yyyy HH:mm:ss");
    String date = formatter.format(currentDate.getTime()).replace("/", "_");
    date = date.replace(":", "_");
    return date;
    
	}
    
    
 
	
	
	
	
}
