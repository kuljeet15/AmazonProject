package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.BaseAmazonClass;

public class PomYourOrders extends BaseAmazonClass {

	@FindBy(css = "#nav_prefetch_yourorders") 
	WebElement yourOrderLink;
	
	@FindBy(id = "a-autoid-1-announce") 
	WebElement pastOrders;
	
	@FindBy(css = "li.page-tabs__tab:nth-child(2)") 
	WebElement buyAgainLink;
	
	@FindBy(css = "#info-B00PL3DK26 > div:nth-child(1) > div:nth-child(1)") 
	WebElement buyAgainProduct;
	
	@FindBy(css = "li.page-tabs__tab:nth-child(3)") 
	WebElement notYetShippedLink;
	
	@FindBy(xpath = "//div[contains(text(),'Looking for an order? ')]") 
	WebElement notYetShippedProduct;
	
	@FindBy(css = "li.page-tabs__tab:nth-child(4)") 
	WebElement cancelledOrdersLink;
	
	@FindBy(css = "div.a-spacing-top-medium:nth-child(1)") 
	WebElement cancelledOrdersProduct;
	
	public PomYourOrders() {
		PageFactory.initElements(driver, this);
	}
	
	public String checkYourOrderLink() {
		
		yourOrderLink.click();
		String urlYourOrderPage = driver.getCurrentUrl();
		return urlYourOrderPage;
	}

   public void CheckPast3MonthsOrders()
    {
	   System.out.print( pastOrders.getText());
	   pastOrders.click();
	   System.out.print( pastOrders.getText());
    }
   
   
   public boolean buyAgainRecommendations ()
	{
	    buyAgainLink.click();
	    return buyAgainProduct.isDisplayed();
	}
   
   public String notYetShipped ()
	{
	    notYetShippedLink.click();
	    return notYetShippedProduct.getText();
	}
   
   public String cancelledOrders ()
	{
	     cancelledOrdersLink.click();
	     return cancelledOrdersProduct.getText();
	}
}