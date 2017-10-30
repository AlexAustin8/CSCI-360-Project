import java.util.*;
public class UserProfile {
	private String profileID;
	private String[] linkedDevices;
	private String username;
	private float strideLength;
	private float weight;
	private ArrayList<Day> history;
	private String[] fields = {"Name", "Stride Length", "Weight", "StepGoal"};
	
	//Some Getter Functions
	public String getProfileID(){
		return profileID;
		
	}
	
	public String getUsername(){
		return username;
		
	}
	public float getStrideLength(){
		return strideLength;
		
	}

}
