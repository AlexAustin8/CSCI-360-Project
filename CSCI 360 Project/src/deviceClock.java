import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.*;
public class deviceClock {
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
	
	public String getDate(){
		LocalDateTime t = LocalDateTime.now();
	    int y = t.getYear();
	    int m = t.getMonthValue();
	    int d = t.getDayOfMonth();
	    DayOfWeek ep = t.getDayOfWeek();
	    
	    
	    String yr = String.format("%04d", y);
	    String mon = String.format("%02d", m);
	    String day = String.format("%02d", d);
	    String weekDay = ep.toString();
        
	    String date = weekDay + ", " + mon + "/" + day + "/" + yr;
	    return date;
		
	}
	

}
