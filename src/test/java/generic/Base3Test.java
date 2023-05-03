package generic;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Base3Test {
	public final String defaultURL="http://www.google.com";
	public WebDriver driver;
	public WebDriverWait wait;
	
	@Parameters({"appurl","grid","browser"})
	@BeforeMethod
	public void preCondition(@Optional(defaultURL) String appURL,String grid,String browser) throws Exception {
		
		if(grid.equalsIgnoreCase("no"))
		{
			Reporter.log("Execution in local system",true);
			if(browser.equals("chrome"))
			{
				Reporter.log("Browser is: chrome",true);
				driver=new ChromeDriver();
			}
			else
			{
				Reporter.log("Browser is: Firefox",true);
				driver=new FirefoxDriver();
			}
		}
		else
		{
			Reporter.log("Execution in remote system",true);
			if(browser.equals("chrome"))
			{
				Reporter.log("Browser is: chrome",true);
				driver=new RemoteWebDriver(new URL(grid), new ChromeOptions());
			}
			else
			{
				Reporter.log("Browser is: Firefox",true);
				driver=new RemoteWebDriver(new URL(grid), new FirefoxOptions());
			}
			
		}
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	@AfterMethod
	public void postCondition() {
		driver.quit();
	}
}

