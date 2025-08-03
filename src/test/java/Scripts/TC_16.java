package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import basicElements.elements;

public class TC_16 
{
	@Test
	public void CopyShippingAddress() throws InterruptedException
	{
		/*1 navigate to application
		2 login to application
		3 navigate to organization
		4naviagate to "create new organization"page by click on "+" image
		5 Check While Creating New Organization "Copy Shipping Address" Select Option Is Enabled Or Not
		6 Logout*/
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");
		elements el = new elements();
		PageFactory.initElements(driver, el);
		el.getUsername().sendKeys("admin");
		el.getPassword().sendKeys("admin");
		el.getSubmitbutton().click();
		el.getOrganization().click();
		driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
		WebElement copy = driver.findElement(By.xpath("(//input[@name='cpy'])[1]"));
		if(copy.isEnabled())
		{
			System.out.println("Copy Shipping Address button is enabled");
		}
		else
		{
			System.out.println("Copy Shipping Address button is dosabled");
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")).click();
		el.getSignout().click();
		driver.quit();
	}
}
