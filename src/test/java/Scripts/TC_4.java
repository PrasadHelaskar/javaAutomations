package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basicElements.elements;

public class TC_4 
{
	@Test
	public void TypeDropDown()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("http://localhost:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");
		elements el = new elements();
		PageFactory.initElements(driver, el);
		el.getUsername().sendKeys("admin");
		el.getPassword().sendKeys("admin");
		el.getSubmitbutton().click();
		el.getOrganization().click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		WebElement ot = driver.findElement(By.name("accounttype"));
		if(ot.isEnabled())
		{
			System.out.println(true+": DropDown is working");
		}
		else
		{
			System.out.println(true+": DropDown is not working");
		}
		driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")).click();
//		Thread.sleep(2000);
		el.getSignout().click();
		driver.quit();
	}
}
