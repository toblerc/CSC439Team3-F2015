package test;
import static org.junit.Assert.*;

import java.CacheRequest;

import org.junit.Before;
import org.junit.Test;

public class TestCacheRequest {

	CacheRequest crtest;
	String directory;
	
	@Before
	public void setUp() throws Exception {
		directory = "C:\\testDirectory\\";
		crtest = new CacheRequest(directory);
	}

	//Test reading the first line of the input.txt
	@Test
	public void readTestOne() {
		assertEquals("www.google.com", crtest.read());
	}
	
	//Test reading the sixth line of input.txt
	@Test
	public void readTestTwo(){
		crtest.read();
		crtest.read();
		crtest.read();
		crtest.read();
		crtest.read();
		assertEquals("www.ask.com", crtest.read());
	}
}
