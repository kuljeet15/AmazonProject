package testlayer;

import javax.swing.text.Utilities;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomLogin;
import pompackage.PomYourAccount;
import testdata.ExcelSheet;

public class YourAccountTest extends BaseAmazonClass{
	
	PomYourAccount accountLog;
	PomLogin log;
	Utilities utilities;
	
	
	public YourAccountTest()
	{
		super();
	}

	@BeforeMethod
	public void initialsetup() throws InterruptedException  
	{
		initiation();
		
		accountLog= new PomYourAccount();
		log= new PomLogin();
		utilities = new Utilities();
		
		
		log.typeValidEmail();
		log.clickContinueButton(); 
		log.typeValidPassword();
		log.clickSignInButton();
		
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
	public void verifyHomePageMsg() throws InterruptedException
	{
		
	 String homePageMsg1 = 	accountLog.homePageMsg();
	 System.out.println("home page msg " + homePageMsg1);
	 Assert.assertTrue(homePageMsg1.contains("Account & Lists"));
	}
	
	@Test
	public void sublistDisplayed() throws InterruptedException
	{
		System.out.print(accountLog.sublistDisplayed());
		Assert.assertTrue(true);
	}
	
	@Test
	public void checkPrimeMembershipLink() throws InterruptedException
	{
		sublistDisplayed();
		String verify = accountLog.checkPrimeMembershipLink();
		Assert.assertTrue(verify.contains("Check out what's included with your Prime membership"));	
	}
	
	@Test
	public void checkMusicLibraryLink() throws InterruptedException
	{
		sublistDisplayed();
		String verifyURL = accountLog.checkMusicLibraryLink();
		Assert.assertEquals(verifyURL, "https://music.amazon.ca/?ref=nav_youraccount_cldplyr");	
	}
	
	@Test
	public void checkYourAccountLink() throws InterruptedException
	{
		sublistDisplayed();
		String verifyURL = accountLog.checkYourAccountLink();
		Assert.assertEquals(verifyURL, "https://www.amazon.ca/gp/css/homepage.html?ref_=nav_AccountFlyout_ya");
	}
	
}
