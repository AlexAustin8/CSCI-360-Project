import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.*;

public class InputReader {
	private int currentStepCount;
	private int currentHeartRate;
	private ArrayList<Instant> heartBeatArray = new ArrayList<Instant>();
	private ArrayList<Integer> avgData = new ArrayList<Integer>();

	
	
	public void stepDetected(){
		currentStepCount++;
	}
	
	
	
	public void detectHeartbeat(){
	    Instant t = Instant.now();
	    heartBeatArray.add(t);
	    
	    
	}
	/**
	 * The setCurrentHeartRate() method checks to see if there are at least 3 objects in heartBeatArray, and if so
	 * converts the objects in to a value representing milliseconds since epoch date. The difference is then calculated
	 * between the 2nd and 1st values, as well as the 3rd and 2nd values, and an average is then calculated from these two
	 * values and this average is then computed in to a value that represents average bpm
	 */
	public void setCurrentHeartRate(){
		if(heartBeatArray.size() < 3){
			currentHeartRate = 0;
		}else{
		  Instant first = heartBeatArray.get(heartBeatArray.size()-1);
		  Instant second = heartBeatArray.get(heartBeatArray.size()-2);
	      Instant third = heartBeatArray.get(heartBeatArray.size()-3);
		
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
	}
	
	public int getCurrentHeartRate(){
		return currentHeartRate;
	}
	
	/**
	 * 
	 * @return avg
	 * 
	 * The getAvgHeartRate() method calculates the average heart rate for a full period by finding the average of all
	 * values saved in the avgData ArrayList. This value is returned.
	 * 
	 * Note that since this operation is only intended to be called as a part of FitBitDevice's saveDay() operation
	 *both ArrayLists are emptied to hold values for the new day.
	 * 
	 */
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
		heartBeatArray.clear();
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


