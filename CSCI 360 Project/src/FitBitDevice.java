import java.util.*;
public class FitBitDevice {
	private String date, profileID, deviceID;
	private Time time;
	private float strideLength;
	private int stepGoal;
	private ArrayList<Day> history = new ArrayList<Day>();
	private InputReader ir;
	
	public float calculateDistance(){
		int steps = ir.getCurrentStepCount();
		return (steps*strideLength);
	}
	
	public Day saveDay(){
		float dist = calculateDistance();
		int steps = ir.getCurrentStepCount();
		boolean goal = (stepGoal <= steps);
		Day d = new Day(date, steps, dist,goal);
		//Find a way to move the date of the object forward
		
	}
	

}
