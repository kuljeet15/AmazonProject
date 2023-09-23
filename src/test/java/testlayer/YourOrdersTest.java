package testlayer;

import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomLogin;
import pompackage.PomYourAccount;
import pompackage.PomYourOrders;
import testdata.ExcelSheet;

public class YourOrdersTest extends BaseAmazonClass{
	
	PomYourOrders orderLog;
	PomLogin log;
	PomYourAccount accountLog;
	Utilities utilities;
	
	public YourOrdersTest()
	{
		super();
	}

	
	@BeforeMethod
	public void initialsetup() throws InterruptedException  
	{
		initiation();
		
		orderLog= new PomYourOrders();
		log= new PomLogin();
		accountLog= new PomYourAccount();
		utilities = new Utilities();
		
		log.typeValidEmail();
		log.clickContinueButton(); 
		log.typeValidPassword();
		log.clickSignInButton();
		accountLog.sublistDisplayed();
		String verifyURL = orderLog.checkYourOrderLink();
		Assert.assertEquals(verifyURL, "https://www.amazon.ca/gp/css/order-history?ref_=nav_AccountFlyout_orders");
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
	public void orderHistoryPast3Months ()
	{
	
		orderLog.CheckPast3MonthsOrders();
	   //Assert.assertEquals(verifyOrderHistory, "past 3 months");
	}
	
	@Test
	public void buyAgainRecommendations ()
	{
	 boolean verify = orderLog.buyAgainRecommendations();
	 Assert.assertTrue(verify);
	}
	
	@Test
	public void notYetShipped ()
	{
	 String text = orderLog.notYetShipped();
	 Assert.assertEquals(text, "Looking for an order? All of your orders have shipped. View all orders");
	}
	
	@Test
	public void cancelledOrders ()
	{
		String text = orderLog.cancelledOrders();
		Assert.assertEquals(text, "We aren't finding any cancelled orders (for orders placed in the last 6 months). View all orders");
	}
	
}
