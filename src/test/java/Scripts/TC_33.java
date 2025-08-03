package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import basicElements.elements;

public class TC_33 
{
	@Test
	public void DuplicateInOrganization()
	{
		/*1 navigate to application
		2 login to application
		3 navigate to organization
		4 navigate to "Find Duplicates"
		5 check "Find Duplicates"
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
		driver.findElement(By.cssSelector("img[title='Find Duplicates']")).click();
		WebElement box = driver.findElement(By.id("availList"));
		Select se = new Select(box);
		se.selectByValue("28");
		driver.findElement(By.name("Button")).click();
		se.selectByValue("32");
		driver.findElement(By.name("Button")).click();
		driver.findElement(By.name("save&merge")).click();
		driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")).click();
		el.getSignout().click();
		Assert.assertEquals(driver.getCurrentUrl(),"http://localhost:8888/index.php?action=Login&module=Users");
		driver.quit();
	}
}
