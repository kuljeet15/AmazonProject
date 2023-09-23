package pompackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class PomGuest extends BaseAmazonClass{
	
	
	@FindBy(id ="twotabsearchtextbox") 
	public WebElement searchItem;
	
	@FindBy(css =".widgetId\\=search-results_1 > div:nth-child(1) > div:nth-child(1) > div:nth-child(1)") 
	public WebElement selectItem;
	
	@FindBy(id ="add-to-cart-button") 
	public WebElement addToCart;
	
	@FindBy(css ="#sc-buy-box-ptc-button > span:nth-child(1)") 
	public WebElement proceedToCheckout;

	@FindBy(css ="h1.a-spacing-small") 
	public WebElement signInPage;
	
	
	
	public PomGuest() {
		PageFactory.initElements(driver, this);
	}
	
	
	public void addItemToCart() throws InterruptedException
	{
		searchItem.sendKeys(prop.getProperty("itemName"));
	    searchItem.submit();
	    selectItem.click();	    
	}
	
	public String PlaceOrderAsGuestUser() throws InterruptedException
	{
		addToCart.click();
	    proceedToCheckout.click();
	    return signInPage.getText();
	}

}
