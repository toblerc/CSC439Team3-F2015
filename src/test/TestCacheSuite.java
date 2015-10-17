/**
 *
 * @author Brycen Davis
 * @date 10-17-2015
 * LRU Proxy Phase 1
 * CSC 439 Team 3 Fall 2015
 * TestCacheSuite.java
 *
 */

package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCacheList.class, TestCacheLog.class, TestCacheRequest.class, TestCacheToFile.class })
public class TestCacheSuite {

}
