package test;
import static org.junit.Assert.*;
import main.CacheList;

import org.junit.Test;

//import org.junit.After;
//import org.junit.AfterClass;
import org.junit.Before;
//import org.junit.BeforeClass;


public class TestCacheList {

	String directory;
	int maxSize;		
	CacheList cltest;
	
	@Before
	public void setUp(){
		directory = "C:\\testDirectory";
		maxSize = 5;
		cltest = new CacheList(directory, maxSize);
	}

	//Test adding only one entry with no overflow
	@Test
	public void addNewObjectTestOne() {
		String returnValue;
		returnValue = cltest.addNewObject("www.google.com", false);
		assertEquals(returnValue, null);
	}
	
	//Test adding six entries with an overflow
	@Test
	public void addNewObjectTestTwo() {
		String returnValue = null;
		cltest.addNewObject("www.google.com", false);
		cltest.addNewObject("www.yahoo.com", false);
		cltest.addNewObject("www.msn.com", false);
		cltest.addNewObject("www.bing.com", false);
		cltest.addNewObject("www.amazon.com", false);
		returnValue = cltest.addNewObject("www.weather.com", false);
		assertEquals(returnValue, "www.google.com");
	}
	
	//Test adding two entries and checking the length of the Linked List
	@Test
	public void getCacheSizeTestOne(){
		cltest.addNewObject("www.yahoo.com", false);
		cltest.addNewObject("www.stackoverflow.com", false);
		assertEquals(2, cltest.getCacheSize());
	}
	
	//Test adding zero entries and checking the length of the Linked List
	@Test
	public void getCacheSizeTestTwo(){
		assertEquals(0, cltest.getCacheSize());
	}
	
	//Test getting the head of the Linked List with no elements added.
	@Test
	public void getHeadTestOne(){
		assertEquals("", cltest.getHead());
	}
	
	//Test getting the head of the Linked List with two elements added.
	@Test
	public void getHeadTestTwo(){
		cltest.addNewObject("www.disney.com", false);
		cltest.addNewObject("www.logitech.com", false);
		assertEquals("www.logitech.com", cltest.getHead());
	}
	
	//Test getting the element 0 of an empty list
	@Test
	public void getTestOne(){
		assertEquals("", cltest.get(0));
	}
	
	//Test getting element 1 of a two element list
	@Test
	public void getTestTwo(){
		cltest.addNewObject("www.samsung.com", false);
		cltest.addNewObject("www.hp.com", false);
		assertEquals("www.samsung.com", cltest.get(1));
	}

}
