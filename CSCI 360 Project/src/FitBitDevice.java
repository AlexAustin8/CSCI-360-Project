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
	private String lastSync = "None";
	private ArrayList<Day> history = new ArrayList<Day>();
	private InputReader ir = new InputReader();
	
	/**
	 * Constructor for the FitBitDevice Class. Randomly generates a Device ID to be used. 
	 * The initialize process is performed automatically because this prototype is only a single system
	 * and therefore, will always be connected.
	 */
	public FitBitDevice(){
		setDeviceID();
		sp = new SyncPlatform();
		profileID = sp.initialize();
		connectToProfile();
	}
	
	
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
	
	public int getStepsUntilGoal(){
		if(stepGoal == 0 || ir.getCurrentStepCount() > stepGoal){
			return 0;
		}else{
			return(stepGoal - ir.getCurrentStepCount());
		}
	}
	
	/**
	 * 
	 * @return String
	 * Returns a string value representing the date of the last recorded Day value
	 */
	public String getLastDayDate(){
		if(history.size() == 0){
			return "No Date Found";
		}
		Day d = history.get(history.size()-1);
		return d.getDate();
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
		//ir.resetSteps();
		return d;
		
	}
	
	/**
	 * connectToProfile is a method utilized to connect to a given user profile. Note that, although it is not specified in design
	 * For the purpose of this prototype, FitBit serves as a creator for SyncPlatform, for demonstration purposes.
	 */
	
	public void connectToProfile(){
		UserProfile up = sp.getProfile(profileID);
		strideLength = up.getStrideLength();
		stepGoal = up.getStepgoal();
		up.addToLinkedDevices(deviceID);
	}
	/**
	 * The sync method calls upon the SyncPlatform Class's profileSync method with the deviceID, profileIDm and history variables
	 * It also saves a value for lastSync, indicating the last date of sync.
	 */
	public void sync(){
		connectToPlatform();
		sp.profileSync(deviceID, profileID, history);
		disconnect();
		if(history.size()>0){
		lastSync = history.get(history.size()-1).getDate();
		}
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
	/**
	 * Randomly generates a number to be used for the DeviceID of the class
	 */
	public void setDeviceID(){
		Random devIdGen = new Random();
		int devId = devIdGen.nextInt(1000) + 1;
		deviceID = "" + devId;
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
	
	public String getLastSyncDate(){
		return lastSync;
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
	
	//Setters for connectivity states. in this prototype, they mainly exist for hypothetical purposes since no true "connection" must be performed
	//However, these would play an important role in actual hardware implementation of the fitbit
	
	public void connectToPlatform(){
		state = "Connected";
	}
	public void disconnect(){
		state = "Disconnected";
	}
	
	

	
	
	
		
	
	

}
