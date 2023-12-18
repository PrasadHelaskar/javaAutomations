package Scripts;

import java.time.Duration;

import org.openqa.selenium.By;
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

import elements.loginmodel;
import net.bytebuddy.utility.RandomString;

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
	@Test
	public void signup() throws InterruptedException
	{
		driver.get("https://demostore.getomnify.com/home?b=t&");
		loginmodel lg= new loginmodel();
		PageFactory.initElements(driver, lg);
		lg.getLoginbutton().click();
		lg.getEmailtestbox().sendKeys(RandomString.make(5)+"@gmail.com");
		lg.getContinuebutton().click();
		if(driver.findElement(By.xpath("//label[text()='Enter Password']")).equals("Enter Password"))
		{
			lg.getPasswordtestbox().sendKeys("1234567890");
		}
		else
		{
			lg.getOTPlogin().click();
			Thread.sleep(10000);
		}
		lg.getLogincontinue().click();	
		lg.getLogout().click();
	}
	@AfterMethod
	public void shutdown()
	{
	    driver.quit();
	}
}