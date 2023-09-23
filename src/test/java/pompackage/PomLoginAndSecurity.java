package pompackage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import basepackage.BaseAmazonClass;

public class PomLoginAndSecurity extends BaseAmazonClass{
	
	
	@FindBy(css = "div.ya-card-row:nth-child(2) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)") 
	WebElement loginAndSecurityLink;
	
	@FindBy(id ="ap_cnep_header") 
	WebElement loginAndSecurityPage;
	
	@FindBy(id ="auth-cnep-edit-name-button") 
	WebElement editName;
	
	@FindBy(id ="ap_customer_name") 
	WebElement newName;
	
	@FindBy(id ="cnep_1C_submit_button") 
	WebElement saveNewName;
	
	@FindBy(css =".a-alert-content") 
	WebElement newNameSaved;
	
	
	public PomLoginAndSecurity() {
		PageFactory.initElements(driver, this);
	}
	

	public String checkLoginAndSecurityLink()
	{
		loginAndSecurityLink.click();
		return loginAndSecurityPage.getText();
	}
	
	public String editName()
	{
		editName.click();
		newName.clear();
		newName.sendKeys(prop.getProperty("newName"));
		saveNewName.click();
		return newNameSaved.getText();
	}
}
