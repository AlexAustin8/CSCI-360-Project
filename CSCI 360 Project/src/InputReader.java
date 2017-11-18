import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.Stack;

public class InputReader {
	private int currentStepCount;
	private int currentHeartRate;
	private StepSensor sSensor = new StepSensor();
	private HeartbeatSensor hSensor = new HeartbeatSensor();
	private Stack<Instant> heartBeatArray = new Stack<Instant>();	

	
	
	public void stepDetected(){
		currentStepCount++;
	}
	
	
	
	public void detectHeartbeat(){
	    Instant t = Instant.now();
	    heartBeatArray.push(t);
	    
	    
	}
	public void setCurrentHeartRate(){
		Instant first = heartBeatArray.pop();
		Instant second = heartBeatArray.pop();
	    Instant third = heartBeatArray.pop();
		
		//Get comparable values for the Instant variables
		long firstTime = first.toEpochMilli();
		long secondTime = second.toEpochMilli();
		long thirdTime = third.toEpochMilli();
		
		
		long oneTwoDiff = secondTime - firstTime;
		long twoThreeDiff = thirdTime - secondTime;
		long avg = (Math.abs(oneTwoDiff) + Math.abs(twoThreeDiff))/ 2;
  		avg = 60000 / avg;
		
		System.out.println(avg);
		//TODO: I currently have this function setting the avg as currentHeartRate,
		//however we must find some formula to convert the average distance between three beats
		//into a Beats-Per-Minute value. I'm sure there's some way to do this.
		
		currentHeartRate = (int)avg;
				
		
	}
	
	public int getCurrentHeartRate(){
		return currentHeartRate;
	}
	
	
	public int getAvgHeartRate(){
		int k = 0;
		return k;
	}
    
	public int getCurrentStepCount(){
		return currentStepCount;
	}
	public int[] getCurrentData(){
		currentHeartRate = hSensor.getCurrentHeartRate();
		int[] vals = {currentHeartRate, currentStepCount};
		return vals;
		
	}
	
		
	}


