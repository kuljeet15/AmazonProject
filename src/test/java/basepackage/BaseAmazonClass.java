package basepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.TimeUtils;

public class BaseAmazonClass {
	    //browser info
		//url info
		
		public static Properties prop = new Properties();
		public static WebDriver driver;
		
		//Step 1
	    public BaseAmazonClass()
	    {
	    	try 
	    	{
	    	FileInputStream file = new FileInputStream("C:\\Selenium\\Selenium_WorkSpace\\AmazonProject\\src\\test\\java\\environmentvariables\\Config.properties");
	        prop.load(file);
	    	}
	    	catch(FileNotFoundException e)
	    	{
	    		e.printStackTrace();
	    	}
	    	catch(IOException a)
	    	{
	    		a.printStackTrace();
	    	}
	    }
	    	
	    //Step 2
	    public static void initiation() throws InterruptedException
	    {
	    	//It will get the property from config file and store in variable
	    	String browsername = prop.getProperty("browser"); 
	    	//driver path
	    	if(browsername.equals("chrome"))
	    	{
	    			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	    			driver = new ChromeDriver();
	    	}
	    	else if(browsername.equals("Firefox"))
	    	{
	    			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
	    			driver = new FirefoxDriver();
	    	}
	    	driver.manage().window().maximize();
	    	
	    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((TimeUtils.implicitWait)));
	    	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TimeUtils.timepage));
	    	
	    	
	    	
	    	
	    	
	    	driver.get(prop.getProperty("url"));
	    	
	    	
	    	Thread.sleep(3000);
	    }
	    		
	    //maximize window, pageload.implicit, url
	    public static void screenshots(String Filename) 
	    {
	    	File files = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    	  try 
	    	  {
	    		FileUtils.copyFile(files, new File("C:\\Selenium\\Selenium_WorkSpace\\HRManagement\\src\\test\\java\\screenshots\\ScreenShots" + Filename + ".jpg"));
	    	
	    	  }
	    	  catch(IOException e)
	    	  {
	    		   e.printStackTrace();
	    	  }
	    	  
	     }
}
