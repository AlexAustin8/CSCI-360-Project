import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class SyncTest extends TestCase {
	    private SyncPlatform sp;
	    private FitBitDevice f;
	    private Day one;
	    private Day two;
	    private Day three;
	    private String[] vals = new String[]{"profile01","the name", "3536", "235"};
	    @Before
	    public void setUp() throws Exception{
	    	sp = new SyncPlatform();
	    	f = new FitBitDevice();
	    	one = new Day("2007/5/20, Monday", 4566,34, true, 45);
			two = new Day("2007/5/21, Tuesday", 4566,34, true, 45);
			three = new Day("2007/5/22, Wednesday", 4566,34, true, 45);		
	}
	    
	    @Test
	    
	    //Tests The Sync operation with valid inputs, both have different values
	    public void testSyncOperation1(){
	    	try{
	    		sp.initialize(vals);
	    		sp.addtoProfileHistory("profile01", one);
	    		sp.addToLinkedDevices("profile01", "id");
	    		ArrayList<Day> testHist = new ArrayList<Day>();
	    		testHist.add(one);
	    		testHist.add(two);
	    		testHist.add(three);
	    		sp.profileSync("id", "profile01", testHist);
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	    	assertEquals(3, sp.getProfile("profile01").getHistory().size(), 0);
	    }
	    
	    //Tests the Sync Operation with valid inputs, both have same values
	    public void testSyncOperation2(){
	    	try{
	    		sp.initialize(vals);
	    		sp.addtoProfileHistory("profile01", one);
	    		sp.addtoProfileHistory("profile01", two);
	    		sp.addtoProfileHistory("profile01", three);
	    		sp.addToLinkedDevices("profile01", "id");
	    		ArrayList<Day> testHist = new ArrayList<Day>();
	    		testHist.add(one);
	    		testHist.add(two);
	    		testHist.add(three);
	    		sp.profileSync("id", "profile01", testHist);
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	    	assertEquals(3, sp.getProfile("profile01").getHistory().size(), 0);
	    }
	    
	    //Tests Sync Operation when invalid DeviceID is used
	    public void testSyncOperation3(){
	    	try{
	    		sp.initialize(vals);
	    		sp.addtoProfileHistory("profile01", one);
	    		sp.addToLinkedDevices("profile01", "id");
	    		ArrayList<Day> testHist = new ArrayList<Day>();
	    		testHist.add(one);
	    		testHist.add(two);
	    		testHist.add(three);
	    		sp.profileSync("newid", "profile01", testHist);
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	    	assertEquals(1, sp.getProfile("profile01").getHistory().size(), 0);
	    }
	    
	    //Tests Sync Operation with an empty History
	    public void testSyncOperation4(){
	    	try{
	    		sp.initialize(vals);
	    		sp.addToLinkedDevices("profile01", "id");
	    		ArrayList<Day> testHist = new ArrayList<Day>();
	    		testHist.add(one);
	    		testHist.add(two);
	    		testHist.add(three);
	    		sp.profileSync("id", "profile01", testHist);
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	    	assertEquals(3, sp.getProfile("profile01").getHistory().size(), 0);
	    }
	    
	    //Tests Sync Operation for the unlikely event that FitBit Device has less data than the Profile
	    public void testSyncOperation5(){
	    	try{
	    		sp.initialize(vals);
	    		sp.addtoProfileHistory("profile01", one);
	    		sp.addtoProfileHistory("profile01", two);
	    		sp.addtoProfileHistory("profile01", three);
	    		sp.addToLinkedDevices("profile01", "id");
	    		ArrayList<Day> testHist = new ArrayList<Day>();
	    		testHist.add(one);
	    		sp.profileSync("id", "profile01", testHist);
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	    	assertEquals(3, sp.getProfile("profile01").getHistory().size(), 0);
	    }
	    
	    //Tests Sync Operation in the case of null FitBitDevice Input
	    public void testSyncOperation6(){
	    	try{
	    		sp.initialize(vals);
	    		sp.addtoProfileHistory("profile01", one);
	    		sp.addtoProfileHistory("profile01", two);
	    		sp.addtoProfileHistory("profile01", three);
	    		sp.addToLinkedDevices("profile01", "id");
	    		sp.profileSync("id", "profile01", null);
	    	}catch(Exception e){
	    		System.out.println(e.getMessage());
	    	}
	    	assertEquals(3, sp.getProfile("profile01").getHistory().size(), 0);
	    }
	    
	    

}
