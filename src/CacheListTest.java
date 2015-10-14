import static org.junit.Assert.*;
import org.junit.Test;

//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;


public class CacheListTest {

	String directory = "C:\\testDirectory";
	int maxSize = 5;		
	CacheList test = new CacheList(directory, maxSize);

	@Test
	public void addNewObjectTestOne() {
		String returnValue;
		 returnValue = test.addNewObject("www.google.com", false);
		 assertEquals(returnValue, null);
	}
	
	@Test
	public void addNewObjectTestTwo() {
		
	}

}
