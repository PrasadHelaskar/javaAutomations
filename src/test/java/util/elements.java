package basicElements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class elements 
{

	@FindBy(name="user_name")
	WebElement username;
	
	@FindBy(name="user_password")
	WebElement password;
	
	@FindBy(id="submitButton")
	WebElement submitbutton;
	
	@FindBy(linkText="Sign Out")
	WebElement signout;
	
	@FindBy(linkText="Organizations")
	WebElement organization;


	public WebElement getOrganization() {
		return organization;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSubmitbutton() {
		return submitbutton;
	}

	public WebElement getSignout() {
		return signout;
	}
	
}
