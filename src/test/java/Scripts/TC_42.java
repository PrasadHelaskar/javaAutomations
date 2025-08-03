package organization;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import basicElements.elements;

public class TC_42 
{
	@Test
	public void SupportGroup() throws InterruptedException
	{
		/*1 navigate to application
		2 login to application
		3 navigate to organization
		4 naviagate to "create new organization"page by click on "+" image
		5 create Organization With "Assigned To" "Support Group"
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
		driver.findElement(By.name("accountname")).sendKeys("TestYentra42");
		driver.findElement(By.cssSelector("input[value='T']")).click();
		WebElement option = driver.findElement(By.name("assigned_group_id"));
		option.click();
		Select se=new Select(option);
		se.selectByValue("4");
		JavascriptExecutor jse =(JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		driver.findElement(By.name("button")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")).click();
		el.getSignout().click();
		driver.quit();
	}
}
