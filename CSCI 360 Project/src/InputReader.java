
public class InputReader {
	private int currentStepCount;
	private int currentHeartRate;
	private StepSensor sSensor;
	private HeartbeatSensor hSensor;
	
	public void addToSteps(){
		currentStepCount++;
	}
	
	public float getAvgHeartRate(){
		
	}
	public void getCurrentData(){
		currentHeartRate = hSensor.getcurrentHeartRate();
		
	}

}
