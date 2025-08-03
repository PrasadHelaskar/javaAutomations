package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import basicElements.elements;

public class TC_23 
{
	@Test
	public void SearchbyAlphabate() throws InterruptedException
	{
		/*1 navigate to application
		2 login to application
		3 navigate to organization
		4 Search The Organization by "Alphabets"
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
		WebElement search = driver.findElement(By.id("bas_searchfield"));
		Select se = new Select(search);
		se.selectByValue("accountname");
		driver.findElement(By.name("search_text")).sendKeys("T");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")).click();
		el.getSignout().click();
		driver.quit();
	}
}
