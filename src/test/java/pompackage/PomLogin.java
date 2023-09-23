package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class PomLogin extends BaseAmazonClass
{
	
	 @FindBy(id = "ap_email") 
	 WebElement emailId;
	 
	 @FindBy(id = "ap_email") 
	 WebElement phone;
	 
	 @FindBy(id = "continue") 
	 WebElement continueButton;
	 
	 @FindBy(id = "ap_password") 
	 WebElement password;
	 
	 @FindBy(css ="div.a-column:nth-child(1)") 
	 WebElement passwordField;
	 
	 @FindBy(id = "signInSubmit") 
	 WebElement signInButton;
	 
	 @FindBy(xpath = "/html/body/div[1]/div[1]/div[2]/div/div[2]/div/div[2]/div/form/div/div[1]/div[2]/div/div") 
	 WebElement emptyPassErrMsg;
	 
	 @FindBy(css = ".a-unordered-list > li:nth-child(1)") 
	 WebElement wrongPassErrMsg;
	 
	 @FindBy(name ="rememberMe") 
	 WebElement keepMeSignedIn;
	 
	 @FindBy(id= "auth-email-missing-alert") 
	 WebElement emptyEmailOrPhoneErrorMsg;
	 
	 @FindBy(css= ".a-unordered-list > li:nth-child(1)") 
	 WebElement inValidEmailErrorMessage;
	 
	 @FindBy(css= ".a-unordered-list") 
	 WebElement inValidPhoneErrorMessage;
	 
   	 @FindBy(id="nav-link-accountList") 
   	 WebElement homePageUrl;
	
		
	public PomLogin() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void emptyEmailOrPhoneNumber()
	{
		emailId.sendKeys(prop.getProperty("emptyEmailId"));
	}
	
	public void typeInvalidEmail()
	{
		emailId.sendKeys(prop.getProperty("invalidEmail"));
	}
	
	public void typeInvalidPhone()
	{
		phone.sendKeys(prop.getProperty("invalidPhoneNumber"));
	}
	
	public void typeValidEmail()
	{
		emailId.sendKeys(prop.getProperty("validEmail"));
	}
	
	public void clickContinueButton() 
	{
		continueButton.click();
	}
	
	public String passwordFieldVisible()
	{
		return passwordField.getText();
	}
	
	public void emptyPassword()
	{
		password.sendKeys(prop.getProperty("emptyPassword"));
	}
	
	public String emptyPassErrorMsg()
	{
		return emptyPassErrMsg.getText();
	}
	
	public String wrongPassErrorMsg()
	{
		return wrongPassErrMsg.getText();
	}
	
	public void typeInvalidPassword()
	{
		password.sendKeys(prop.getProperty("invalidPassword"));
	}
	
	public void typeValidPassword()
	{
		password.sendKeys(prop.getProperty("validPassword"));
	}
	
	public void clickSignInButton() 
	{
		signInButton.click();
	}
	
	public void SignInCheckbox()
	{
		keepMeSignedIn.click();
	}
	
	public String emptyEmailOrPhoneError()
	{
		return emptyEmailOrPhoneErrorMsg.getText();
	}
	
	public String inValidEmailError()
	{
		return inValidEmailErrorMessage.getText();
	}
	
	public String inValidPhoneError()
	{
		return inValidPhoneErrorMessage.getText();
	}
	
	public String getHomePageURL()
	{
		return driver.getCurrentUrl();
	}
}
