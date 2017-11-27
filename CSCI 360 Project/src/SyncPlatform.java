import java.util.*;

public class SyncPlatform {
	private ArrayList<UserProfile> profiles = new ArrayList<UserProfile>();
	
	//Allows for initialization process to occur without user input. Intended for testing purposes.
	public String testInitialize(String[] profileVals){
		UserProfile d = new UserProfile(profileVals);
	    profiles.add(d);
		return profileVals[0];
	}
	
	/**
	 * 
	 * @return profileID
	 * 
	 * The initialize method creates a UserProfile object with values specified by the user and then returns the profileID
	 * To the FitBit device so that the two objects are connected.
	 */
	public String initialize(){
		String[] profileVals = enterProfileData();
		UserProfile d = new UserProfile(profileVals);
	    profiles.add(d);
		return profileVals[0];
	}
	
	/**
	 * The enterProfileData() function is used to get the user data that 
	 * the profile will be instantiated with. 
	 * @return String array of values to create user profile with
	 */
	public String[] enterProfileData(){
		String[] profileVals = new String[5]; 
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a Profile ID: "); 
		profileVals[0] = in.nextLine();
		
		System.out.println("Please enter your name: ") ; 
		profileVals[1] = in.nextLine(); 
		
		System.out.println("Please enter your Stride Length (in feet): "); 
		profileVals[2]= in.nextLine();
				
		System.out.println("Please enter your weight (in pounds): "); 
		profileVals[3] = in.nextLine(); 
		
		System.out.println("Please enter in your daily step goal: "); 
		profileVals[4] = in.nextLine(); 
		
		in.close();
		return profileVals;
		
		
	}
	/**
	 * 
	 * @param profileID
	 * @return User profile object that contains profileID as 
	 * its profileID. If not found, function returns null
	 */
	public UserProfile getProfile(String profileID){
		for(int i = 0; i < profiles.size(); i++){
			UserProfile temp = profiles.get(i);
			String tempID = temp.getProfileID();
			if(tempID.equals(profileID)){
				return profiles.get(i);
			}
		}
		return null;
		
	}
	
	public void addProfile(UserProfile up){
		profiles.add(up);
	}
	
	
	/**
	 * 
	 * @param devID
	 * @param profileID
	 * @param devHist
	 * 
	 *The profileSync method receives ArrayList <Day> devHist that is the history stored on a FitBitDevice
	 *And checks it against the  ArrayList <Day> history of the profile specified by the profileID. Any days
	 *Not present on the <Day> history of the profile are added, and then an assert is done to ensure that both
	 *ArrayLists are identical
	 */
	public void profileSync(String devID, String profileID, ArrayList<Day> devHist){
		if(devHist!=null){
		  UserProfile u = getProfile(profileID);
		  if(u!=null){
		     if (u.verifyLinkedDevice(devID)){
		     	ArrayList<Day> profileHist = u.getHistory();
		     	int lastDev = devHist.size();
		    	int lastProf = profileHist.size();
		    	while(lastProf < lastDev){
		    		u.addToHistory(devHist.get(lastProf));
		    		lastProf++;
		    	}
		    	assert(u.equalHistory(devHist));		    	
		     }
			
		   }
	    }
	}
	
	//Methods to allow for FitBitDevice Interaction with User Profiles, Primarily For Testing/Prototype Purposes
	
	/**
	 * 
	 * @param profileID
	 * @param d
	 * Adds Day d to the history of the UserProfile object with the specified profileID
	 */
	public void addtoProfileHistory(String profileID, Day d){
		UserProfile temp = getProfile(profileID);
		temp.addToHistory(d);
		for(int i = 0; i < profiles.size(); i++){
			UserProfile up = profiles.get(i);
			String upID = temp.getProfileID();
			if(upID.equals(profileID)){
				profiles.set(i, temp);
			}
		
	     }
	}
	
	/**
	 * 
	 * @param profileID
	 * @param deviceID
	 * Adds the specified device ID to the linkedDevices<String> ArrayList in the UserProfile Object with 
	 * the Specified profileID
	 */
	public void addToLinkedDevices(String profileID, String deviceID){
		UserProfile temp = getProfile(profileID);
		temp.addToLinkedDevices(deviceID);
		for(int i = 0; i < profiles.size(); i++){
			UserProfile up = profiles.get(i);
			String upID = temp.getProfileID();
			if(upID.equals(profileID)){
				profiles.set(i, temp);
			}
		
	     }
		

		
	}
	

}
