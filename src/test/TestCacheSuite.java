package test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestCacheList.class, TestCacheLog.class, TestCacheRequest.class, TestCacheToFile.class })
public class TestCacheSuite {

}
