package Scripts;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class login 
{
	WebDriver driver;
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
			driver= new ChromeDriver();
		else if(browser.equalsIgnoreCase("Edge"))
			driver= new EdgeDriver();
		else if(browser.equalsIgnoreCase("Firefox"))
			driver= new FirefoxDriver();
		else if(browser.equalsIgnoreCase("Safari"))
			driver= new SafariDriver();
		else
			System.out.println("Entered browser is not listed");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void shutdown()
	{
	    driver.quit();
	}
	@Test
	public void signup()
	{
		driver.get("https://www.google.com");
	}
}
