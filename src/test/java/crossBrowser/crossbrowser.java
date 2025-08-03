package automationtest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class crossbrowser 
{
	 WebDriver driver;


	 @BeforeTest
	 @Parameters("browser")
	 public void setup(String browser) throws Exception 
	 {
	   if (browser.equalsIgnoreCase("firefox")) 
		   driver = new FirefoxDriver(); 
	   else if (browser.equalsIgnoreCase("chrome"))
		   driver = new ChromeDriver();
	   else if (browser.equalsIgnoreCase("Edge"))
		   driver = new EdgeDriver();
	   else if (browser.equalsIgnoreCase("Safari"))
		   driver = new SafariDriver();
	   else
		   throw new Exception("Incorrect Browser");
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 }

	@Test
	public void test()
	{
		driver.get("https://demostore.getomnify.com");
		System.out.println("Title is: " + driver.getTitle());
		AssertJUnit.assertEquals(driver.getTitle(), "Magma - Corporation - Group - Book Services Online | Omnify");
		driver.quit();
	}

}    
