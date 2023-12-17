package elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginmodel 
{
	@FindBy(id="login-email")
	private WebElement emailtestbox;
	
	@FindBy(xpath="//button[text()='Continue']")
	private WebElement continuebutton;
	
	@FindBy(id="login-password")
	private WebElement passwordtestbox;
	
	@FindBy(xpath="(//button[text()='Login'])[2]")
	private WebElement logincontinue;
	
	@FindBy(xpath="//div[text()='Forgot Password?']")
	private WebElement ForgotPassword;
	
	@FindBy(xpath="//button[contains(text(),'One-time-passcode')]")
	private WebElement OTPlogin;

	public WebElement getEmailtestbox() {
		return emailtestbox;
	}

	public WebElement getContinuebutton() {
		return continuebutton;
	}

	public WebElement getPasswordtestbox() {
		return passwordtestbox;
	}

	public WebElement getLogincontinue() {
		return logincontinue;
	}

	public WebElement getForgotPassword() {
		return ForgotPassword;
	}

	public WebElement getOTPlogin() {
		return OTPlogin;
	}
}
