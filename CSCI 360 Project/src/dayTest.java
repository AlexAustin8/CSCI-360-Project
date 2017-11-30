import java.util.ArrayList;

import junit.framework.TestCase;

public class dayTest extends TestCase {
	private Day d1;
	private Day d2;
	private Day d3;
	private Day d4;
	int result;
	String toString;
	
	public void setUp() throws Exception {
		d1 = new Day("2007/12/30", (int)3423, (float)325.1, false, 67);
		d2 = new Day("2007/12/30", (int)3423, (float)325.1, false, 67);
		d3 = new Day("2007/12/29", (int)3423, (float)325.1, false, 67);
		d4 = new Day("2008/11/19", (int)2414, (float)2345.2, true, 123);
	}
    
	public void testCompareTo1(){
    	try{
    		result = d1.compareTo(d2);
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	assertEquals(0, result, 0);
    }
	
	public void testCompareTo2(){
    	try{
    		result = d1.compareTo(d3);
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	assertEquals(1, result, 0);
    }
	
	public void testCompareTo3(){
    	try{
    		result = d1.compareTo(d4);
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	assertEquals(-1, result, 0);
    }
	
	public void testCompareTo4(){
    	try{
    		result = d4.compareTo(d1);
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	assertEquals(1, result, 0);
    }
	
	public void testCompareTo5(){
    	try{
    		result = d4.compareTo(null);
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	assertEquals(-3, result, 0);
    }
	
	public void testToString1(){
    	try{
    		toString = d1.toString();
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	System.out.println(toString);
    	assertEquals("Date: 2007/12/30 Steps Taken:3423 Distance Walked: 325.1 Step Goal Was Not Met", toString);
    }
	
	public void testToString2(){
    	try{
    		toString = d4.toString();
    	}catch(Exception e){
    		System.out.println(e.getMessage());
    	}
    	System.out.println(toString);
    	assertEquals("Date: 2008/11/19 Steps Taken:2414 Distance Walked: 2345.2 Goal Was Met", toString);
    }
	
}
