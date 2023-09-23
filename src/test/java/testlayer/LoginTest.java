package testlayer;
import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomLogin;
import testdata.ExcelSheet;


public class LoginTest extends BaseAmazonClass {

	PomLogin log;
	Utilities utilities;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void initialsetup() throws InterruptedException  
	{
		initiation();
		log= new PomLogin();
		utilities = new Utilities();
	}
	
	@DataProvider
	public Object[][] Details()
	{
		//this object array will accept data from excel sheet
		Object result[][] = ExcelSheet.readdata("Sheet1");
	    return result;
	}
	
	  @Test (priority =1)
	  public void emptyEmailAddress() 
	  {  
	  log.emptyEmailOrPhoneNumber(); 
	  log.clickContinueButton(); 
	  String errorMsg =  log.emptyEmailOrPhoneError();
	  Assert.assertEquals(errorMsg, "Enter your e-mail address or mobile phone number");
      }
	  
	  @Test (priority =2)
	  public void invalidEmailAddress() 
	  {  
	  log.typeInvalidEmail(); 
	  log.clickContinueButton(); 
	  String errorMsg =  log.inValidEmailError();
	  Assert.assertEquals(errorMsg, "We cannot find an account with that e-mail address");
	  }
	  
	  @Test (priority =4)
	  public void invalidPhone() 
	  {  
	  log.typeInvalidPhone(); 
	  log.clickContinueButton(); 
	  String errorMsg =  log.inValidPhoneError();
	  Assert.assertEquals(errorMsg, "We cannot find an account with that mobile number");
	  }
	  
	  @Test (priority =3)
	  public void validEmailAddress() 
	  {  
	  log.typeValidEmail(); 
	  log.clickContinueButton(); 
	  String passField = log.passwordFieldVisible();
	  Assert.assertEquals(passField, "Password");
	  }
	 
	  @Test (priority =5)
	  public void emptyPassword() throws InterruptedException 
	  { 
	  log.typeValidEmail();
	  log.clickContinueButton(); 
	  log.emptyPassword();
	  log.clickSignInButton();
	  String emptyPassErrMsg = log.emptyPassErrorMsg();
	  Assert.assertEquals(emptyPassErrMsg, "Enter your password");  
	  }
	  
	  
	  @Test (priority =6)
	  public void validEmailAndPassword() throws InterruptedException 
	  {  
	  log.typeValidEmail();
	  log.clickContinueButton(); 
	  log.typeValidPassword();
	  log.clickSignInButton();
	  String homePageUrl = log.getHomePageURL();
	  Assert.assertEquals(homePageUrl, "https://www.amazon.ca/?ref_=nav_signin");
	  }
	
	  @Test (priority =7)
	  public void keepMeSignedIn() throws InterruptedException
	  {
		  log.typeValidEmail();
		  log.clickContinueButton(); 
		  log.typeValidPassword();
		  log.SignInCheckbox();
		  log.clickSignInButton(); 
	  }
	  
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
