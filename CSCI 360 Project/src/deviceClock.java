import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.*;
public class deviceClock {
	/**
	 * 
	 * @return Time
	 * The getTime method returns a String representing the current time in a simple format
	 */
	public String getTime(){
		LocalDateTime t = LocalDateTime.now();
	    int h = t.getHour();
	    int m = t.getMinute();
	    int s = t.getSecond();
	    
	    String hr = String.format("%02d", h);
	    String min = String.format("%02d", m);
	    String sec = String.format("%02d", s);
	    String time = hr + ":" + min + ":" + sec;
	    return time;
	    
	}
	/**
	 * 
	 * @return Date
	 * The getDate method returns a String representing the current date in a simple format
	 * For demonstration purposes, there is a field for minute added to the return value
	 * so that the date value changes every minute, rather than every 24 hours.
	 */
	public String getDate(){
		LocalDateTime t = LocalDateTime.now();
	    int y = t.getYear();
	    int m = t.getMonthValue();
	    int d = t.getDayOfMonth();
	    
	    //Here the min variable is added to make it so that days change every minute, for presentation purposes.
	    int min = t.getMinute();
	    String minute = String.format("%02d", min);
	    DayOfWeek ep = t.getDayOfWeek();
	    
	    
	    String yr = String.format("%04d", y);
	    String mon = String.format("%02d", m);
	    String day = String.format("%02d", d);
	    String weekDay = ep.toString();
        
	    String date = yr + "/" + mon + "/" + day + "," + weekDay + " : " + minute;
	    //String date = yr + "/" + mon + "/" + day + "," + weekDay;
	    return date;
		
	}
	
	

}
