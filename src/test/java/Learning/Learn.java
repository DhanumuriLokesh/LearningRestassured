package Learning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Learn {
	
	
	@Test
	void test1() {
		System.out.println("this method is test1");
	}
	
	@Test(dependsOnMethods =  "test1" )
	void test2(){
		System.out.println("thsi is depepnt on the test 1");
		
	}
	
	
	
	

}
