import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class InputReader {
	private int currentStepCount;
	private int currentHeartRate;
	//private StepSensor sSensor = new StepSensor();
	private Stack<Instant> heartBeatArray = new Stack<Instant>();
	private ArrayList<Integer> avgData = new ArrayList<Integer>();

	
	
	public void stepDetected(){
		currentStepCount++;
	}
	
	
	
	public void detectHeartbeat(){
	    Instant t = Instant.now();
	    heartBeatArray.push(t);
	    
	    
	}
	public void setCurrentHeartRate(){
		if(heartBeatArray.size() < 3){
			currentHeartRate = 0;
		}
		Instant first = heartBeatArray.pop ();
		Instant second = heartBeatArray.pop();
	    Instant third = heartBeatArray.pop();
		
		//Get comparable values for the Instant variables
		long firstTime = first.toEpochMilli();
		long secondTime = second.toEpochMilli();
		long thirdTime = third.toEpochMilli();
		
		
		long oneTwoDiff = secondTime - firstTime;
		long twoThreeDiff = thirdTime - secondTime;
		long avg = (Math.abs(oneTwoDiff) + Math.abs(twoThreeDiff))/ 2;
		if (avg == 0){
			currentHeartRate = 0;
		}else{
  		    avg = 60000 / avg;
	     	avgData.add((int)avg);
		    currentHeartRate = (int)avg;
		}
				
		
	}
	
	public int getCurrentHeartRate(){
		return currentHeartRate;
	}
	
	
	public int getAvgHeartRate(){
		if(avgData.size() == 0){
			return 0;
		}
		int tot = 0;
		for(int i = 0; i<avgData.size(); i++){
			tot += avgData.get(i);
		}
		int avg = tot/avgData.size();
		avgData.clear();
		return avg;
	}
	
	/**
	 * 
	 * @param num
	 * Note that this function is not actually used in implementation, but is defined
	 * here for testing purposes.
	 */
	public void addToAvgData(int num){
		avgData.add(num);
		
	}
	
	public void resetSteps(){
		currentStepCount = 0;
	}
    
	public int getCurrentStepCount(){
		return currentStepCount;
	}
	public int[] getCurrentData(){
		int[] vals = {currentHeartRate, currentStepCount};
		return vals;
		
	}
	
		
	}


