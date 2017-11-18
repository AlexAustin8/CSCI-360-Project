import java.util.*;
public class Day {
	private String date;
	private int stepsTaken;
	private float distance;
	private boolean goalMet;

	
	public Day(String newDate,int stepCount,float dist,boolean goal){
		date = newDate;
		stepsTaken = stepCount;
		distance = dist;
		goalMet = goal;
	}
	
	
	public String toString(){
		String goal =  "Step Goal Was Not Met";
		if(goalMet){
			goal = "Goal Was Met";
		}
		return("Date: " + date + " Steps Taken:" + stepsTaken + " Distance Walked: " + distance + " " + goal);
	}
	
	
	
}

