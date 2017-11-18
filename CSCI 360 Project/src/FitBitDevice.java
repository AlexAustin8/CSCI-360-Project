import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.*;
public class FitBitDevice {
	private String profileID, deviceID;
	private String currDate = "unset";
	//String date has been changed to Calendar currDate
	private deviceClock clock =  new deviceClock();
	private float strideLength;
	private int stepGoal;
	private ArrayList<Day> history = new ArrayList<Day>();
	private InputReader ir = new InputReader();
	
	/**
	 * Calculates the distance traveled by user by multiplying stepCount by 
	 * the strideLength
	 * @return float value representing distance traveled.
	 */
	public float calculateDistance(){
		int steps = ir.getCurrentStepCount();
		return (steps*strideLength);
	}
	
	public Day saveDay(){
		float dist = calculateDistance();
		int steps = ir.getCurrentStepCount();
		boolean goal = (stepGoal <= steps);
		Day d = new Day(currDate, steps, dist,goal);
		history.add(d);
		//Note that this may not be syntactically correct. More research should be done
		return d;
		
	}
	
	public void connectToProfile(){
		SyncPlatform p = new SyncPlatform();
		//Leaving the method here until Sync Platform / Initializer
		//responsibilities are more thought out.
	}
	
	//Setter functions for the instance variables.
	
	public void setStepGoal(int step){
		stepGoal = step;
	}
	
	public void setCurrDate(String s){
		currDate = s;
	}
	
	public void setProfileID(String id){
		profileID = id;
	}
	
	public void setDeviceID(String id){
		deviceID = id;
		//We may want to consider making this function work by randomly generating a 
		//DeviceID, but we'll see
	}
	
	public void setStrideLength(float len){
		strideLength = len;
	}
	
	//Getter functions for the instance variables
	
	public int getStepGoal(){
		return stepGoal;
	}
	
	public String getProfileID(){
		return profileID;
	}
	
	public String getDeviceID(){
		return deviceID;
	}
	
	public float getStrideLength(){
		return strideLength;
	}
	
	public ArrayList<Day> getHistory(){
		return history;
	}
	
	public String getTime(){
		return clock.getTime();
	    
	}
	
	public String getDate(){
		String date = clock.getDate();
		if(currDate.compareTo("unset")==0){
			currDate = date;
		}else if(currDate.compareTo(date) != 0){
			saveDay();
		}
		
		return date;
	}
	
	public static void main(String args[]){
		FitBitDevice f = new FitBitDevice();
		System.out.println(f.history.toString());
		System.out.println(f.getDate());
		System.out.println(f.getDate());
		System.out.println(f.history.toString());
		
	    
	    
	     
		

		
	}
	
	
	
		
	
	

}
