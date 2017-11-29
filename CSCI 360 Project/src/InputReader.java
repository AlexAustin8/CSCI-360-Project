import java.time.Instant;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.util.Random;

public class InputReader {
	private int currentStepCount;
	private int previousStepCount = 0;
	private int differenceOfStepCount;
	private int currentHeartRate;
	private ArrayList<Instant> heartBeatArray = new ArrayList<Instant>();
	private ArrayList<Integer> avgData = new ArrayList<Integer>();
	private Random rand = new Random();

	
	
	public void stepDetected(){
		currentStepCount++;
	}
	
	public void stepDifference() {
		differenceOfStepCount = currentStepCount - previousStepCount;
		previousStepCount = currentStepCount;
	}
	
	public int calculateHeartRate() {
		if (differenceOfStepCount <= 0) {
			if (currentHeartRate > 82) {
				currentHeartRate = currentHeartRate - (rand.nextInt(7) + 3);
			}
			else {
				currentHeartRate = 76 + rand.nextInt(7);
			}
		}
		else {
			currentHeartRate = 76 + rand.nextInt(7) + (differenceOfStepCount * 10);
		}
		return 0;
	}
	
	public int getCurrentHeartRate(){
		stepDifference();
		calculateHeartRate();
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


