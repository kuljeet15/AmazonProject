package pompackage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class PomSearching extends BaseAmazonClass{
	
	@FindBy(id ="twotabsearchtextbox") 
	WebElement searchBar;
	
	@FindBy(partialLinkText = "T-Shirt")
	public List<WebElement> searchByKeyword;
	
	@FindBy(partialLinkText ="Tote Bag for Woman")
	public List<WebElement> searchByDescriptionText;
	
	@FindBy(partialLinkText ="thermo")
	public List<WebElement> searchByPartialItemText;
	
	@FindBy(css = "div.s-result-item:nth-child(1) > div:nth-child(1) > span:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(1)")
	WebElement resultsOfSearchItemNumber;
	
	@FindBy(tagName = "img")
	public List<WebElement> totalProductsPerPage;
	
	@FindBy(css = "a.s-pagination-item:nth-child(8)")
	public WebElement nextButton;
	
	@FindBy(css = "span.s-pagination-item:nth-child(4)")
	public WebElement secondPage;
	
	
	public PomSearching() 
	{
		PageFactory.initElements(driver, this);
	}

	JavascriptExecutor jse = (JavascriptExecutor) driver;
	

	public void searchItemByKeyword() 
	{
		searchBar.sendKeys(prop.getProperty("searchProductByKeyword"));
		searchBar.submit();
	}
	
	public void searchItemByDescriptionText() 
	{
		searchBar.sendKeys(prop.getProperty("searchProductByDescription"));
		searchBar.submit();
	}
	
	
	public void searchItemByPartialItemText() 
	{
		searchBar.sendKeys(prop.getProperty("partialItemName"));
		searchBar.submit();
	}

	public String searchItemByItemNumber() throws InterruptedException 
	{
		searchBar.sendKeys(prop.getProperty("itemNumber"));
		searchBar.submit();
		return resultsOfSearchItemNumber.getText();
	}
	
	public String searchItemByPartialItemNumber() throws InterruptedException 
	{
		searchBar.sendKeys(prop.getProperty("partialItemNumber"));
		searchBar.submit();
		return resultsOfSearchItemNumber.getText();
	}
	
	
	
	public void nextPage() throws InterruptedException
	{
		jse.executeScript("window.scrollBy(0,5000)", "");
		nextButton.click();
	
	}
	
	public String verifySecondPage() throws InterruptedException
	{
		jse.executeScript("window.scrollBy(0,9100)", "");
		return secondPage.getText();
	}

}

