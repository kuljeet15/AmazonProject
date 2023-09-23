package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class PomYourAccount extends BaseAmazonClass {
	
	Actions action = new Actions(driver);

	@FindBy(id = "nav-link-accountList") 
	WebElement homePageMsg;
	
	@FindBy(css = ".nav-flyout-sidePanel-content") 
	WebElement sublist;
	
	@FindBy(css = "#nav-al-your-account > a:nth-child(7)") 
	WebElement primeMembershipLink;
	
	@FindBy(css = "div.mcx-widget__container--content:nth-child(1)") 
	WebElement verifyPrimeMembershipLink;
	
	@FindBy(css = "a.nav-link:nth-child(11)") 
	WebElement musicLibraryLink;
	
	@FindBy(css = "#nav-al-your-account > a:nth-child(2)") 
	WebElement yourAccountLink;
	
	public PomYourAccount() 
	{
		PageFactory.initElements(driver, this);
	}
	
	public String homePageMsg()
	{
		return homePageMsg.getText();
	}
	
	public boolean sublistDisplayed() throws InterruptedException
	{
		action.moveToElement(homePageMsg).build().perform();
		return sublist.isDisplayed();
	}
	
	public String checkPrimeMembershipLink()
	{
		primeMembershipLink.click();
		return verifyPrimeMembershipLink.getText();
	}
	
	public String checkMusicLibraryLink()
	{
		musicLibraryLink.click();
		String urlMusicLibraryPage = driver.getCurrentUrl();
		return urlMusicLibraryPage;
	}
	
	public String checkYourAccountLink()
	{
		yourAccountLink.click();
		String urlYourAccountPage = driver.getCurrentUrl();
		return urlYourAccountPage;
	}	
}

