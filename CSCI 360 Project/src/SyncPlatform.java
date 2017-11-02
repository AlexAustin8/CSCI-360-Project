import java.util.*;
/**
 * NOTE: Before more work is done in this class, we must
 * better define Initializer vs. SyncPlatform responsibilities. 
 * Let's Consider States to detect connectivity
 * @author Alex
 *
 */
public class SyncPlatform {
	private ArrayList<UserProfile> profiles = new ArrayList<UserProfile>();
	
	
	public void initialize(){		
		String[] profileVals = enterProfileData();
		UserProfile d = new UserProfile(profileVals);
	    profiles.add(d);
		
		//As far as connection goes, we may want to consider using a "State" for connected and unconnected
	    //Either way the whole "connectToDevice" will be left undefined for now
	}
	
	/**
	 * The enterProfileData() function is used to get the user data that 
	 * the profile will be instantiated with. For now, it is working though
	 * Scanner and Print statements, but later, it will probably be necessary for 
	 * us to figure out a way to make it work with a UI
	 * @return String array of values to create user profile with
	 */
	public String[] enterProfileData(){
		String[] profileVals = new String[4]; 
		Scanner in = new Scanner(System.in);
		System.out.println("Please enter a Profile ID"); //For the sake of ensuring profile ID's are unique, we should 
		profileVals[0] = in.nextLine(); //Find an algorithm to generate them later on
		
		System.out.println("Please enter your name"); 
		profileVals[1] = in.nextLine(); 
		
		System.out.println("Please enter your strideLength"); 
		profileVals[2]= in.nextLine();
				
		System.out.println("Please enter your weight"); 
		profileVals[3] = in.nextLine(); 
		
		in.close();
		return profileVals;
		
		
	}
	/**
	 * 
	 * @param profileID
	 * @return User profile object that contains profileID as 
	 * its profileID. If not found, function returns null
	 */
	private UserProfile getProfile(String profileID){
		for(int i = 0; i < profiles.size(); i++){
			UserProfile temp = profiles.get(i);
			String tempID = temp.getProfileID();
			if(tempID.equals(profileID)){
				return profiles.get(i);
			}
		}
		return null;
		
	}
	/**
	 * 
	 * @param devHist-History from FitBit Device
	 * @param profileHist- History from UserProfile
	 * 
	 * This function must find a way to calculate the difference in days
	 * in the two ArrayList<Day> objects. Return type is currently set to void
	 * because, due to lack of experience with the Calendar Class, I am unsure 
	 * what exactly the return type will be.
	 */
	public void calcDateDifference(ArrayList<Day> devHist, ArrayList<Day> profileHist){
	}
	
	
	
	public void profileSync(String devID, String profileID, ArrayList<Day> devHist){
		UserProfile u = getProfile(profileID);
		if(u!=null){
		    if (u.verifyLinkedDevice(devID)){
		    	ArrayList<Day> profileHist = u.getHistory();
		    	//TODO: The rest of the profileSync function can be determined once
		    	//The calcDateDifference is figured out
		    }
			
		    }
	    }
	

}
