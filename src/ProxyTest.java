import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class ProxyTest {

	Proxy ptest;
	String inDirectory;
	int maxCacheSize, sleepSeconds;
	
	@Before
	public void setUp() throws Exception {
		inDirectory = "C:\\testDirectory";
		maxCacheSize = 10;
		sleepSeconds = 1;
		ptest = new Proxy(inDirectory, maxCacheSize, sleepSeconds);
	}

	//Test to see the first input string
	@Test
	public void cacheRequestTestOne() {
		String returnValue;
		returnValue = ptest.cacheRead();
		assertEquals("www.google.com", returnValue);
	}
	
	//Test to see the fifth input string
	@Test
	public void cacheRequestTestTwo() {
		String returnValue;
		ptest.cacheRead();
		ptest.cacheRead();
		ptest.cacheRead();
		ptest.cacheRead();
		returnValue = ptest.cacheRead();
		assertEquals("www.yahoo.com", returnValue);
	}
	
	//Test to see if entry one exists in the cache without any other entries
	/*@Test
	public void isAlreadyCachedTestOne(){
		boolean returnValue;
		ptest.cacheRead();
		returnValue = ptest.isAlreadyCached("www.google.com");
		assertEquals(returnValue, false);
	}
	
	@Test
	public void isAlreadyCachedTestTwo(){
		boolean returnValue;
		ptest.isAlreadyCached(ptest.cacheRead());
		ptest.isAlreadyCached(ptest.cacheRead());
		ptest.isAlreadyCached(ptest.cacheRead());
		returnValue = ptest.isAlreadyCached(ptest.cacheRead());
		assertEquals(true, returnValue);
	} */
	
	

}
