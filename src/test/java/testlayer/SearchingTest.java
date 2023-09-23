package testlayer;

import javax.swing.text.Utilities;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepackage.BaseAmazonClass;
import pompackage.PomGuest;
import pompackage.PomLogin;
import pompackage.PomSearching;
import testdata.ExcelSheet;

public class SearchingTest extends BaseAmazonClass{
	
	PomSearching searchingLog;
	PomLogin log;
	Utilities utilities;
	
	public SearchingTest()
	{
		super();
	}
	
	@BeforeMethod
	public void initialsetup() throws InterruptedException  
	{
		initiation();
		
		searchingLog = new PomSearching();
		utilities = new Utilities();
		
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

    @Test(priority = 1)
	public void searchByKeyword() throws InterruptedException
	{
	    searchingLog.searchItemByKeyword();
		System.out.println(searchingLog.searchByKeyword.size());
		for(int i = 0; i<5; i++)
		{
			for(int j =0; j<1; j++)
			{
				Assert.assertEquals(searchingLog.searchByKeyword.get(j).getText().contains("T-Shirt"), true);
			}
			System.out.println(searchingLog.searchByKeyword.get(i).getText());
		}
	}

     @Test(priority = 2)
     public void searchByDescriptionText() throws InterruptedException
     {
    	 searchingLog.searchItemByDescriptionText();
    	 System.out.println(searchingLog.searchByDescriptionText.size());
 		 for(int i = 0; i<searchingLog.searchByDescriptionText.size(); i++)
 		 {
 			for(int j =0; j<1; j++)
 			{
 				Assert.assertEquals(searchingLog.searchByDescriptionText.get(j).getText().contains("Tote Bag for Woman"), true);
 			}
 			System.out.println(searchingLog.searchByDescriptionText.get(i).getText());
 		 }
     }
     
     @Test(priority = 3)
     public void searchItemByPartialItemText() throws InterruptedException
     {
    	 searchingLog.searchItemByPartialItemText();
    	 System.out.println(searchingLog.searchByPartialItemText.size());
 		 for(int i = 0; i<searchingLog.searchByPartialItemText.size(); i++)
 		 {
 			for(int j =0; j<1; j++)
 			{
 				Assert.assertEquals(searchingLog.searchByPartialItemText.get(j).getText().contains("thermo"), true);
 			}
 			System.out.println(searchingLog.searchByPartialItemText.get(i).getText());
 		 }
     }
     
     @Test(priority = 4)
     public void searchItemByItemNumber() throws InterruptedException
     {
  
    	 Assert.assertEquals(searchingLog.searchItemByItemNumber(), "Results");
     }
     
     @Test(priority = 5)
     public void searchItemByPartialItemNumber() throws InterruptedException
     {
  
    	 Assert.assertEquals(searchingLog.searchItemByPartialItemNumber(), "Results");
     }
     
     @Test(priority = 6)
     public void productsPerPage() throws InterruptedException
     {
    	 searchingLog.searchItemByKeyword();
    	 System.out.println("Total number of products displaying on page are: " + searchingLog.totalProductsPerPage.size() + "\nNumber of products per page must be 60");
         Assert.assertEquals(searchingLog.totalProductsPerPage.size(), "60");
     }
     
     @Test(priority = 7)
     public void nextPage() throws InterruptedException 
     {
    	 searchingLog.searchItemByKeyword();
    	 searchingLog.nextPage();
    	 Assert.assertEquals(searchingLog.verifySecondPage(), "2");
     }
}

