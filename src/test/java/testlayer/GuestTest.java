package testlayer;
import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomGuest;
import testdata.ExcelSheet;

public class GuestTest extends BaseAmazonClass
{
	
	PomGuest guestLog;
	Utilities utilities;
	
	public GuestTest()
	{
		super();
	}
	
	@BeforeClass
	public void initialsetup() throws InterruptedException  
	{
		initiation();
		
		guestLog = new PomGuest();
		Utilities utilities;
		driver.get(prop.getProperty("url1"));
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
	public void PlaceOrderAsGuestUser() throws InterruptedException
	{
	    guestLog.addItemToCart();
	    Assert.assertEquals(guestLog.PlaceOrderAsGuestUser(), "Order Placed Successfully");
	}
}
