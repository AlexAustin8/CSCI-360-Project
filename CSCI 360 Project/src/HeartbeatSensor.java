import java.util.*;
import java.time.*;

public class HeartbeatSensor {
	private Stack<Instant> heartBeatArray = new Stack<Instant>();
	private int currentHeartRate;
	
	/**
	 * 
	 * Senses a heart beat and returns a time object that details the time 
	 * of the heartbeat
	 */
	public void detectHeartbeat(){
	    Instant t = Instant.now();
	    heartBeatArray.push(t);
	}
	
	/**
	 * Takes the three most recent values added to heartBeatArray, and calculates average distance
	 * between them
	 */
	public void setCurrentHeartRate(){
		 Instant first = heartBeatArray.pop();
		 Instant second = heartBeatArray.pop();
	     Instant third = heartBeatArray.pop();
		
		//Get comparable values for the Instant variables
		long firstTime = first.getEpochSecond();
		long secondTime = second.getEpochSecond();
		long thirdTime = third.getEpochSecond();
		
		long oneTwoDiff = secondTime - firstTime;
		long twoThreeDiff = thirdTime - secondTime;
		long avg = (oneTwoDiff + twoThreeDiff) / 2;
		
		//TODO: I currently have this function setting the avg as currentHeartRate,
		//however we must find some formula to convert the average distance between three beats
		//into a Beats-Per-Minute value. I'm sure there's some way to do this.
		
		System.out.println(avg);
		currentHeartRate = (int)avg;
				
		
	}
	
    //addToHeartBeatArray function was deleted because it is not necessary
	
	public int getCurrentHeartRate(){
		return currentHeartRate;
	}
	/**
	 * 
	 * The main is here to simply do some preliminary testing before we get the JUnit up, and to make
	 * sure that we are using Instant right
	 */
	public static void main (String args[]){
		HeartbeatSensor x = new HeartbeatSensor();
		x.detectHeartbeat();
		x.detectHeartbeat();
		x.detectHeartbeat();
		x.setCurrentHeartRate();
		x.detectHeartbeat();
		x.detectHeartbeat();
		x.detectHeartbeat();
		x.setCurrentHeartRate();
		x.detectHeartbeat();
		x.detectHeartbeat();
        
		
	}

}
