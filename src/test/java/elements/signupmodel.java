package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class signupmodel 
{
		@FindBy(xpath="//button[contains(text(),'Create')]") private WebElement signupbuttion;
	    @FindBy(id="login-email") private WebElement logintextfield; 
	    @FindBy(xpath="//button[text()='Continue']") private WebElement continuebutton;
	    @FindBy(name = "firstname") private WebElement firstname;
	    @FindBy(id="lastname") private WebElement lastname;
	    @FindBy(css="div[role='combobox']") private WebElement flag;
	    @FindBy(id="iti-0__item-us-preferred") private WebElement UK;
	    @FindBy(id="phone") private WebElement Number;
	    @FindBy(xpath = "//input[@type='submit' and @value='Submit']") private WebElement continuebutton1;
	    @FindBy(id="password") private WebElement password;
	    @FindBy(id="confirm_password") private WebElement confirmpassword;
	    @FindBy(xpath = "//div[text()='Additional details']") private WebElement Additiondata;
		public WebElement getSignupbuttion() {
			return signupbuttion;
		}
		public WebElement getLogintextfield() {
			return logintextfield;
		}
		public WebElement getContinuebutton() {
			return continuebutton;
		}
		public WebElement getFirstname() {
			return firstname;
		}
		public WebElement getLastname() {
			return lastname;
		}
		public WebElement getFlag() {
			return flag;
		}
		public WebElement getUK() {
			return UK;
		}
		public WebElement getNumber() {
			return Number;
		}
		public WebElement getContinuebutton1() {
			return continuebutton1;
		}
		public WebElement getPassword() {
			return password;
		}
		public WebElement getConfirmpassword() {
			return confirmpassword;
		}
		public WebElement getAdditiondata() {
			return Additiondata;
		}
	    
}
