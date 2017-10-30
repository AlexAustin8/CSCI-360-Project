
public class InputReader {
	private int currentStepCount;
	private int currentHeartRate;
	private StepSensor sSensor = new StepSensor();
	private HeartbeatSensor hSensor = new HeartbeatSensor();
	
	//It may be wise to consider where exactly this should be placed. 
	//Perhaps we put this into the StepSensor, and then just use a getter to get the
	//value into InputReader. We should prob do this,but I'll need to adjust some diagrams :(
	public void addToSteps(){
		currentStepCount++;
	}
	
	public float getAvgHeartRate(){
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
