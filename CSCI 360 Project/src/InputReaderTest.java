import junit.framework.TestCase;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.concurrent.TimeUnit;

public class InputReaderTest extends TestCase {
		private InputReader ir;
		@Before
		public void setUp() throws Exception {
			ir = new InputReader();
		}

		@Test
		/**
		 * Tests for the setCurrentHeartRate Method in InputReader
		 * 
		 */
		
		
		public void testSetCurrentHeartRate1() {
			try{
				ir.detectHeartbeat();
				TimeUnit.SECONDS.sleep(1);
				ir.detectHeartbeat();
				TimeUnit.MILLISECONDS.sleep(500);
				ir.detectHeartbeat();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			ir.setCurrentHeartRate();
			assertEquals(80, ir.getCurrentHeartRate(), 1);
		}
		
		public void testSetCurrentHeartRate2() {
			try{
				ir.detectHeartbeat();
				TimeUnit.SECONDS.sleep(1);
				ir.detectHeartbeat();
				TimeUnit.SECONDS.sleep(1);
				ir.detectHeartbeat();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			ir.setCurrentHeartRate();
			assertEquals(60, ir.getCurrentHeartRate(), 1);
		}
		public void testSetCurrentHeartRate3() {
			try{
				ir.detectHeartbeat();
				TimeUnit.SECONDS.sleep(1);
				ir.detectHeartbeat();
				TimeUnit.SECONDS.sleep(3);
				ir.detectHeartbeat();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			ir.setCurrentHeartRate();
			assertEquals(30, ir.getCurrentHeartRate(), 1);
		}
		public void testSetCurrentHeartRate4() {
			try{
				ir.detectHeartbeat();
				ir.detectHeartbeat();
				ir.detectHeartbeat();
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			ir.setCurrentHeartRate();
			assertEquals(0, ir.getCurrentHeartRate(), 1);
		}
		
		
		
		/**
		 * Tests for the getAvgHeartRate Method in InputReader
		 */
		
		
		
		
		public void testGetAvgHeartRate1() {
			ir.addToAvgData(50);
			ir.addToAvgData(150);
			ir.addToAvgData(100);
			assertEquals(100, ir.getAvgHeartRate(), 1);
		}
		public void testGetAvgHeartRate2() {
			assertEquals(0, ir.getAvgHeartRate(), 1);
		}
	}
		
		