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
	}
		
		