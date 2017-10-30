import java.util.*;
public class Day {
	private Calendar date;
	private int stepsTaken;
	private float distance;
	private boolean goalMet;

	
	public Day(Calendar newDate,int stepCount,float dist,boolean goal){
		date = newDate;
		stepsTaken = stepCount;
		distance = dist;
		goalMet = goal;
	}
}

