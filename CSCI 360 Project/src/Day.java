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
}

