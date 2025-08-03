package organization;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import basicElements.elements;

public class TC_13 
{
	@Test
	public void RatingDropBox()
	{
		/*1 navigate to application
		2 login to application
		3 navigate to organization
		4naviagate to "create new organization"page by click on "+" image
		5Check While Creating New Organization "Rating" Drop Down Option Is Working Or Not
		6 logout*/
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
		WebElement rate = driver.findElement(By.name("rating"));
		rate.click();
		Select se = new Select(rate);
		if(rate.isDisplayed())
		{
			List<WebElement> options = se.getOptions();
			for(WebElement i:options)
			{
				System.out.println(i.getText());
			}
		}
		else
		{
			System.out.println("Rating dropdDown is not Working");
		}
		driver.findElement(By.xpath("//td[@onmouseout=\"fnHideDrop('ondemand_sub');\"]")).click();
		el.getSignout().click();
		driver.quit();
	}
}