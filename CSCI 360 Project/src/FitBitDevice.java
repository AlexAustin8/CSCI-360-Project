import java.util.*;
import java.util.concurrent.TimeUnit;
import java.time.*;

public class FitBitDevice {
	
	
	//Variable Declarations
	private String profileID, deviceID;
	private String currDate = "unset";
	private String state = "normal";
	private SyncPlatform sp;
	private deviceClock clock =  new deviceClock();
	private float strideLength;
	private int stepGoal;
	private ArrayList<Day> history = new ArrayList<Day>();
	private InputReader ir = new InputReader();
	
	
	//Method Definitions
	
	
	/**
	 * Calculates the distance traveled by user by multiplying stepCount by 
	 * the strideLength
	 * @return float value representing distance traveled.
	 */
	
	public float calculateDistance(){
		int steps = ir.getCurrentStepCount();
		return (steps*strideLength);
	}
	
	public void addToSteps(){
		this.getDate();
		ir.stepDetected();
	}
	
	public void detectHeartbeat(){
		this.getDate();
		ir.detectHeartbeat();
	}
	
	public int getCurrentHeartrate(){
		this.getDate();
		ir.setCurrentHeartRate();
		return ir.getCurrentHeartRate();
	}
	
	
	
	
	/**
	 * 
	 * @return Day
	 * The saveDay method creates a new Day instance with all data relevant to be stored.
	 * This new instance is than added to history, and returned.
	 */
	
	public Day saveDay(){
		float dist = calculateDistance();
		int steps = ir.getCurrentStepCount();
		int avgRate = ir.getAvgHeartRate();
		boolean goal = (stepGoal <= steps);
		Day d = new Day(currDate, steps, dist,goal, avgRate);
		history.add(d);
		ir.resetSteps();
		return d;
		
	}
	
	/**
	 * connectToProfile is a method utilized to connect to a given user profile. Note that, although it is not specified in design
	 * For the purpose of this prototype, FitBit serves as a creator for SyncPlatform, for demonstration purposes.
	 */
	
	public void connectToProfile(){
		SyncPlatform p = new SyncPlatform();
		//Leaving the method here until Sync Platform / Initializer
		//responsibilities are more thought out.
	}
	
	public void sync(){
		 
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
	public void setSyncPlatform(SyncPlatform s){
		sp = s;
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
	
	public int getCurrentSteps(){
		return ir.getCurrentStepCount();
	}
	
	
	/**
	 * 
	 * @return String Date
	 * Note How this method is not only used to retrieve a date value, but also to do a check to see whether or not the
	 * date has changed, and if so, the saveDay operation is then performed.
	 */
	
	public String getDate(){
		String date = clock.getDate();
		if(currDate.compareTo("unset")==0){
			currDate = date;
		}else if(currDate.compareTo(date) != 0){
			saveDay();
			currDate = date;
		}
		
		return date;
	}
	
	public void connectToPlatform(){
		state = "Connected";
	}
	
	public void profileSync(){
		
	}
	
	public static void main(String args[]){
		try{
		FitBitDevice f = new FitBitDevice();
		f.addToSteps();
		System.out.println(f.getDate());
		System.out.println(f.getCurrentSteps());
		System.out.println(f.getHistory());
		TimeUnit.MINUTES.sleep(1);
		System.out.println(f.getDate());
		System.out.println(f.getCurrentSteps());
		System.out.println(f.getHistory());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	    
	    
	     
		

		
	}
	
	
	
		
	
	

}
