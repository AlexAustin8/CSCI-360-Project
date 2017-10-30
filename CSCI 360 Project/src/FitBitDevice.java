import java.util.*;
public class FitBitDevice {
	private String profileID, deviceID;
	//String date has been changed to Calendar currDate
	private Calendar currDate = Calendar.getInstance();
	//I think that we can use Calendar for time, so we may be able to delete the time variable
	private Time time;
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
		currDate.roll(currDate.DATE, 1);
		//Note that this may not be syntactically correct. More research should be done
		//into the Calendar class to see the proper way to increment date by 1.
		
	}
	
	public void connectToProfile(){
		SyncPlatform p = new SyncPlatform;
		//Leaving the method here until Sync Platform / Initializer
		//responsibilities are more thought out.
	}
	
	//Setter functions for the instance variables.
	
	public void setStepGoal(int step){
		stepGoal = step;
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
	
	
	
		
	
	

}
