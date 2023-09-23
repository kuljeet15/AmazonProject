package pompackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.BaseAmazonClass;

public class PomShoppingCart extends BaseAmazonClass{

	@FindBy(css = ".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
	WebElement selectItem;
	
	@FindBy(css = ".widgetId\\=search-results_2 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)")
	public WebElement select2ndItem;
	
	@FindBy(id = "sw-gtc") 
	WebElement goToCartButton;
	
	@FindBy(css = "div.a-spacing-mini:nth-child(7)") 
	WebElement subTotal;
	
	@FindBy(css = "div.sc-item-content-group:nth-child(3) > ul:nth-child(1) > li:nth-child(1) > span:nth-child(1) > a:nth-child(1)") 
	public WebElement nameOfAddedItem;
	
	@FindBy(css = ".a-button-span11") 
	public WebElement goToCart2;
	
	@FindBy(css = "span.sc-action-delete:nth-child(3) > span:nth-child(1)") 
	public WebElement deleteButton;
	
	@FindBy(id = "spc-gcpromoinput") 
	public WebElement enterCoupon;
	
	@FindBy(id = "gcApplyButtonId") 
	public WebElement applyCoupon;
	
	@FindBy(css = "#gc-error") 
	public WebElement couponErrMsg;
	
	public PomShoppingCart() 
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickOnSelectedItem() 
	{
		selectItem.click();
	}
	
	public void selectSecondItem()
	{
	    select2ndItem.click();
	}
	
	public void goToCart() 
	{
		goToCartButton.click();
	}
	
	public boolean verifySubTotal()
	{
		return subTotal.isDisplayed();
	}
	
	public String nameOfAddedItemInCart()
	{
     	return nameOfAddedItem.getText();
	}
	
	
	public void enterInvalidCoupon()
	{
     	enterCoupon.sendKeys(prop.getProperty("invalidCoupon"));
	}
	
	public void applyInvalidCoupon()
	{
     	applyCoupon.click();
	}
	
	public boolean invalidCouponErrMsg()
	{
     	return couponErrMsg.isDisplayed();
	}
}

