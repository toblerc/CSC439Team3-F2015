/**
 *
 * @author Brycen Davis
 * @date 10-17-2015
 * LRU Proxy Phase 1
 * CSC 439 Team 3 Fall 2015
 * TestCacheLog.java
 *
 */

package test;
import static org.junit.Assert.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import main.CacheLog;

public class TestCacheLog {

	String directory;
	CacheLog cltest;
	static BufferedReader in;
	
	// Adds in the testDirectory and copies the input file
	// into the directory for use later
	@BeforeClass
	public static void setUpOnce(){
		String newDirectory = "C:\\testDirectory\\";
		File path = new File(newDirectory);
		
		//Remove pre-test contamination
		if(path.exists()){
			deleteDirectory(path);
		}
		
		if(!path.exists()){
			path.mkdirs();
		}
	}
		
	//Delete testDirectory
	@AfterClass
	public static void tearDownOnce(){
		String directory = "C:\\testDirectory\\";
		deleteDirectory(new File(directory));
	}
			
	// Recursively delete the testDirectory and all files inside,
	// thus leaving file system unchanged
	private static boolean deleteDirectory(File path){
		if(path.exists()){
			File[] files = path.listFiles();
			for (int i = 0; i < files.length; i++){
				if(files[i].isDirectory()){
					deleteDirectory(files[i]);
				} else {
					files[i].delete();
				}
			}
		}
		return (path.delete());
	}
	
	//Create a new BufferedReader Object
	private static void fileReader(String directory){
		String filename=directory+"/output.log";
		try
		{
			in = new BufferedReader(new FileReader(filename));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	//Read the first line from file
	private String read()
	{
		String line="";
		try
		{
			line=in.readLine();
			if (line == null)
			{
				line="";
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return line;
	}
	
	//Delete old log files before creating a new one
	private void removeLogFile(){
		File logFile = new File(this.directory + "/output.log");
		if(logFile.exists()){
			logFile.delete();
		}	
	}
	
	@Before
	public void setUp() throws Exception {
		this.directory = "C:\\testDirectory\\";
		removeLogFile();
		cltest = new CacheLog(directory);
	}

	//Test logRemoval method
	@Test
	public void logRemovalTest() {
		try {
			String testValue = "www.yahoo.com";
			cltest.logRemoval(testValue);
			fileReader(this.directory);
			String returnValue = read();
			String logValue = testValue + " the cached page is evicted";
			assertEquals(true, returnValue.contains(logValue));
			in.close();
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Test logHit method
	@Test
	public void logHitTest() {
		try {
			String testValue = "www.msn.com";
			cltest.logHit(testValue);
			fileReader(this.directory);
			String returnValue = read();
			String logValue = testValue + " cache hit";
			assertEquals(true, returnValue.contains(logValue));
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Test logMiss method
	@Test
	public void logMissTest() {
		try {
			String testValue = "www.google.com";
			cltest.logMiss(testValue);
			fileReader(this.directory);
			String returnValue = read();
			String logValue = testValue + " cache miss";
			assertEquals(true, returnValue.contains(logValue));
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
