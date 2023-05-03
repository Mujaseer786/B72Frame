package script;

import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class Demo1Test extends BaseTest
{
	@Test
	public void demoTest1() {
			
			Reporter.log(driver.getTitle(),true);	

	}
}
