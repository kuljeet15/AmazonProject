package testlayer;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomLogin;
import pompackage.PomYourAccount;
import pompackage.PomYourAddress;
import pompackage.PomYourOrders;
import testdata.ExcelSheet;

public class YourAddressTest extends BaseAmazonClass{
	
	PomYourOrders orderLog;
	PomLogin log;
	PomYourAccount accountLog;
	PomYourAddress addressLog;
	Utilities utilities;
	
	public YourAddressTest()
	{
		super();
	}
	
	@BeforeClass
	public void initialsetup() throws InterruptedException  
	{
		initiation();
		
		orderLog= new PomYourOrders();
		log= new PomLogin();
		accountLog= new PomYourAccount();
		addressLog  = new PomYourAddress();
		utilities = new Utilities();
		
		log.typeValidEmail();
		log.clickContinueButton(); 
		log.typeValidPassword();
		log.clickSignInButton();
		accountLog.sublistDisplayed();
		accountLog.checkYourAccountLink();
		addressLog.clickYourAddress();
		addressLog.clickAddAddress();
	}

	@AfterClass
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
	
	

	@Test (priority =1)
	public void emptyAddressDetailsErrMsgs() throws InterruptedException
	{
	   initialsetup();
		
	   addressLog.clickAddAddressButton();
	   if (addressLog.enterFullName().equals(null)) 
	   {
	   Assert.assertEquals(addressLog.fullNameErrMsg(), "Please enter a name.");
	   }
	   if (addressLog.enterPhoneNumber().equals(null)) 
	   {
		   Assert.assertEquals(addressLog.phoneNumberErrMsg(), "Please enter a phone number so we can call if there are any issues with delivery.");
	   }
	   if (addressLog.enterAddress().equals(null)) 
	   {
		   Assert.assertEquals(addressLog.addressErrMsg(), "Please enter an address.");
	   }
	   if (addressLog.enterCity().equals(null)) 
	   {
		   Assert.assertEquals(addressLog.cityErrMsg(), "Please enter a city name.");
	   }
	   if (addressLog.selectProvince())
	   {
		   System.out.println("asserts passed: ");
		   Assert.assertEquals(addressLog.provinceNotSelected(), "Please enter a province/territory.");
		   System.out.println("asserts passed: ");
	   }
	   if (addressLog.enterPostalCode().equals(null)) 
	   {
		   Assert.assertEquals(addressLog.postalCodeErrMsg(), "Please enter a postal code.");
	   } 
	}
	
	@Test (priority =3)
	public void checkAddressAddedSuccessfully()
	{
		String addAdded = addressLog.addressAddedSuccessfully();
	      
        boolean verify = addAdded.contains("Address saved"); 
         if(verify) 
        {
        	Assert.assertEquals(addAdded, "Address saved");
        }
         else
         {
         	String addressAlreadyExist = addressLog.addressAlreadyExist();
         	Assert.assertEquals(addressAlreadyExist, "You've submitted an address that is already in your address book");
         }
	}
	
	@Test (priority =2)
	public void addAddress()
	{
		String text = addressLog.checkCountryRegion();
		Assert.assertEquals(text, "Canada");
		
		addressLog.enterFullName();
		addressLog.enterPhoneNumber();
		addressLog.enterAddress();
		addressLog.enterCity();
		addressLog.selectProvince();
		addressLog.enterPostalCode();
		addressLog.makeDefaultAddress();
	    addressLog.choseDeliveryInstructions();
	   
	     addressLog.clickAddAddressButton();
	}
}
