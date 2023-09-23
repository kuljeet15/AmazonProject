package testlayer;

import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomGuest;
import pompackage.PomLogin;
import pompackage.PomSearching;
import pompackage.PomShoppingCart;

import testdata.ExcelSheet;

public class ShoppingCartTest  extends BaseAmazonClass{

	PomSearching searchingLog;
	PomLogin log;
	PomGuest guestLog;
	PomShoppingCart cartLog;
	Utilities utilities;
	
	public ShoppingCartTest()
	{
		super();
	}
	
	@BeforeMethod
	public void initialsetup() throws InterruptedException  
	{
		initiation();
		
		searchingLog = new PomSearching();
		log= new PomLogin();
		guestLog = new PomGuest();
		cartLog = new PomShoppingCart();
		utilities = new Utilities();
		
		log.typeValidEmail();
		log.clickContinueButton(); 
		log.typeValidPassword();
		log.clickSignInButton();
		searchingLog.searchItemByKeyword();	
	}

   // @AfterMethod
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
	
	@Test(priority =1)
	public void addOneItemInCart() 
	{
		cartLog.clickOnSelectedItem();
	    guestLog.addToCart.click();
		cartLog.goToCart();
		Assert.assertEquals(cartLog.verifySubTotal(), true);	
	}
	
	@Test(priority =4)
	public void removeItemFromCart() 
	{
		cartLog.goToCart2.click();
		cartLog.deleteButton.click();
	}
	
	@Test(priority =3)
	public void addDifferentItems() 
	{
		cartLog.clickOnSelectedItem();
		guestLog.addToCart.click();
		searchingLog.searchItemByKeyword();
		cartLog.select2ndItem.click();
		guestLog.addToCart.click();
		cartLog.goToCart();
		Assert.assertEquals(cartLog.verifySubTotal(), true);
		
	}
	
    @Test(priority =2)
	public void applyInvalidCoupon() 
	{
		//cartLog.clickOnSelectedItem();
		//guestLog.addToCart.click();
    	cartLog.goToCart2.click();
		guestLog.proceedToCheckout.click();
		cartLog.enterInvalidCoupon();
		cartLog.applyInvalidCoupon();
		Assert.assertEquals(cartLog.invalidCouponErrMsg(), false);
	}
	
}
