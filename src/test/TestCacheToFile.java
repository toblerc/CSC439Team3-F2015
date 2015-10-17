/**
 *
 * @author Brycen Davis
 * @date 10-17-2015
 * LRU Proxy Phase 1
 * CSC 439 Team 3 Fall 2015
 * TestCacheToFile.java
 *
 */

package test;
import static org.junit.Assert.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import main.CacheToFile;

public class TestCacheToFile {

	String directory;
	CacheToFile ctftest;
	
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
		this.directory = "C:\\testDirectory\\";
		ctftest = new CacheToFile(directory);
	}	

	//Test remove method
	@Test
	public void removeTest() {
		String testURL = "www.google.com";
		File testFile = new File(this.directory + testURL);
		try {
			testFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ctftest.remove(testURL);
		assertEquals(false, testFile.exists());
	}
	
	//Test isCached method
	@Test
	public void isCachedTest(){
		String testURL = "www.bing.com";
		assertEquals(true, ctftest.isCached(testURL));
	}
}
