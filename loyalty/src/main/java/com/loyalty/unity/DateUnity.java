package com.loyalty.unity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUnity {
	
	public static SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");
	
	 public static Date beforeOfDay(int beforeDay) {
	        Calendar dCal = Calendar.getInstance();
	        dCal.add(Calendar.DATE, beforeDay);
	        return dCal.getTime();
	      }
	    public static Date afterOfDay(int afterDay) {
	        Calendar dCal = Calendar.getInstance();
	        dCal.add(Calendar.DATE, afterDay);
	        return dCal.getTime();
	      }
	    
	    public static String getCurrentTimeStamp() {
		    Date now = new Date();
		    String strDate = sdfDate.format(now);
		    return strDate;
		}

}
