import java.util.*;
public class Day {
	private String date;
	private int stepsTaken, avgHeartRate;
	private float distance;
	private boolean goalMet;

	
	public Day(String newDate,int stepCount,float dist,boolean goal, int avgRate){
		date = newDate;
		stepsTaken = stepCount;
		distance = dist;
		goalMet = goal;
		avgHeartRate = avgRate;
	}
	/**
	 * 
	 * @param d
	 * @return 
	 * 
	 * Checks two Day objects against one another to see if the dates are equal
	 */
	public int compareTo(Day d){
		if(d == null){
			return -3;
		}
		if(this.date.compareTo(d.getDate()) < 0){
			return -1;
		}
		else if(this.date.compareTo(d.getDate()) == 0){
			return 0;
		}
		else{
			return 1;
		}
	}
	
	public String getDate(){
		return date;
	}
	
	public int getSteps(){
		return stepsTaken;
	}
	
	
	public String toString(){
		String goal =  "Step Goal Was Not Met";
		if(goalMet){
			goal = "Goal Was Met";
		}
		return("Date: " + date + " Steps Taken:" + stepsTaken + " Distance Walked: " + distance + " " + goal);
	}
	
	
	
	
}

