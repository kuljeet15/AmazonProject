package testlayer;

import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomLogin;
import pompackage.PomLoginAndSecurity;
import pompackage.PomYourAccount;
import pompackage.PomYourAddress;
import pompackage.PomYourOrders;
import testdata.ExcelSheet;

public class LoginAndSecurityTest extends BaseAmazonClass{
	
	PomLogin log;
	PomYourAccount accountLog;
	PomLoginAndSecurity loginAndSecurityLog;
	Utilities utilities;
	
	public LoginAndSecurityTest()
	{
		super();
	}
	
	@BeforeClass
	public void initialsetup() throws InterruptedException  
	{
		initiation();
		
		log= new PomLogin();
		accountLog= new PomYourAccount();
		loginAndSecurityLog = new PomLoginAndSecurity();
		utilities = new Utilities();
		
		log.typeValidEmail();
		log.clickContinueButton(); 
		log.typeValidPassword();
		log.clickSignInButton();
		accountLog.sublistDisplayed();
		accountLog.checkYourAccountLink();
		Assert.assertEquals(loginAndSecurityLog.checkLoginAndSecurityLink(), "Login & Security");
	}

	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] Details()
	{
		//this object array will accept data from excel sheet
		Object result[][] = ExcelSheet.readdata("Sheet1");
	    return result;
	}
	
	@Test
	 public void editName()
	 {
		 Assert.assertEquals(loginAndSecurityLog.editName(), "You successfully changed your account!");
	 }
	
}
