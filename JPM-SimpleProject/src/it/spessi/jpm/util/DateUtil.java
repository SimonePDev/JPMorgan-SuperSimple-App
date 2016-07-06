package it.spessi.jpm.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DateUtil {

	
	public static boolean isPAssedGivenTimeRange(Date date1, Date date2,int givedTime,TimeUnit timeUnit){
		long dateDiff = getDateDiff(date1, date2, timeUnit);
		return dateDiff >= givedTime;
	}
	
	public static long getDateDiff(Date date1, Date date2, TimeUnit timeUnit) {
	    long diffInMillies = date2.getTime() - date1.getTime();
	    return (diffInMillies/1000)/60;
	}
}
