package Scripts;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import elements.signupmodel;
import net.bytebuddy.utility.RandomString;

public class signup 
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
	@Test
	public void siguup() throws InterruptedException
	{
		driver.get("https://demostore.getomnify.com/home?b=t&");
		signupmodel sg= new signupmodel();
		PageFactory.initElements(driver, sg);
		sg.getSignupbuttion().click();
		sg.getLogintextfield().sendKeys(RandomString.make(4)+"@getomnify.com");
		sg.getContinuebutton().click();
		sg.getFirstname().sendKeys(RandomString.make(4));
		sg.getLastname().sendKeys(RandomString.make(4));
		sg.getNumber().sendKeys("201"+new Random().nextInt(7));
		sg.getContinuebutton1().click();
		sg.getPassword().sendKeys("123123123");
		sg.getConfirmpassword().sendKeys("123123123");
		sg.getContinuebutton1().click();
		if(sg.getAdditiondata().isDisplayed())
		{
			Thread.sleep(20000);
		}
	}
	@AfterMethod
	public void shutdown()
	{
	    driver.quit();
	}
}
