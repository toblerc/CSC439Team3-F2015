/**
 *
 * @author Brycen Davis
 * @date 10-17-2015
 * LRU Proxy Phase 1
 * CSC 439 Team 3 Fall 2015
 * TestCacheRequest.java
 *
 */

package test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import main.CacheRequest;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestCacheRequest {

	CacheRequest crtest;
	String directory;
	
	// Adds in the testDirectory and copies the input file
	// into the directory for use later
	@BeforeClass
	public static void setUpOnce(){
		String newDirectory = "C:\\testDirectory\\";
		File file = new File(newDirectory);
		if(!file.exists()){
			file.mkdirs();
			File source = new File("data\\input.txt");
			File dest = new File(newDirectory + "input.txt");
			try {
				Files.copy(source.toPath(), dest.toPath());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
