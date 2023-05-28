package com.horse.track.horsetrack.validator;

public class InputValidator {

	public static boolean havingNumber(String input) {
	        return input.matches(".*[0-9].*");
	    }

	public static boolean numberRange(Integer horseNumber) {;
	        return horseNumber >= 1 && horseNumber <= 7 ? true : false;
	    }
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	        if((Math.ceil(d)-Math.floor(d))>0) {
	        	System.out.println("Number contails floating point");
	        	return false;
	        }
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
}
