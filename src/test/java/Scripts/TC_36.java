package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import basicElements.elements;

public class TC_36 
{
	@Test
	public void SendMail()
	{
		/*1 navigate to application
		2 login to application
		3 navigate to organization
		4 Check The "Send Mail" From Organization Records
		5 Logout*/
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://localhost:8888/index.php?module=Home&action=index&parenttab=My%20Home%20Page");
		elements el = new elements();
		PageFactory.initElements(driver, el);
		el.getUsername().sendKeys("admin");
		el.getPassword().sendKeys("admin");
		el.getSubmitbutton().click();
		el.getOrganization().click();
		driver.findElement(By.id("37")).click();
		driver.findElement(By.cssSelector("input[value='Send Mail']")).click();
		driver.findElement(By.name("Cancel")).click();
		driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")).click();
		el.getSignout().click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8888/index.php?action=Login&module=Users");
		driver.quit();

	}
}
