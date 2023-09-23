package pompackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import basepackage.BaseAmazonClass;

public class PomYourAddress extends BaseAmazonClass {
	
	
	@FindBy(css = "div.ya-card-row:nth-child(3) > div:nth-child(1) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)") 
	WebElement clickYourAddress;
	
	@FindBy(css = ".a-padding-extra-large") 
	WebElement clickAddAddress;
	
	@FindBy(css = "#address-ui-widgets-countryCode-dropdown-nativeId") 
	WebElement checkCountryRegion;
	
	@FindBy(id = "address-ui-widgets-enterAddressFullName") 
	WebElement fullName;
	
	@FindBy(css = "#address-ui-widgets-enterAddressFullName-full-validation-alerts > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)") 
	WebElement fullNameErrMsg;
	
	@FindBy(id = "address-ui-widgets-enterAddressPhoneNumber") 
	WebElement phoneNumber;
	
	@FindBy(css = "#address-ui-widgets-enterAddressPhoneNumber-full-validation-alerts > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)") 
	WebElement phoneNumberErrMsg;
	
	@FindBy(id = "address-ui-widgets-enterAddressLine1") 
	WebElement address;
	
	@FindBy(css = "#address-ui-widgets-enterAddressLine2-full-validation-alerts > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)") 
	WebElement addressErrMsg;
	
	@FindBy(id = "address-ui-widgets-enterAddressCity") 
	WebElement city;
	
	@FindBy(css = "#address-ui-widgets-enterAddressCity-full-validation-alerts > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)") 
	WebElement cityErrMsg;
	
	@FindBy(xpath = "//span[@id='address-ui-widgets-enterAddressStateOrRegion']//span[@class='a-button-text a-declarative' and @role='button']") 
	WebElement province;
	
	@FindBy(css = "#address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId_8")
	WebElement selectProvince;
	
	
	@FindBy(css = "#address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId-full-validation-alerts > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1)")
	WebElement provinceNotSelected;
	
	@FindBy(id = "address-ui-widgets-enterAddressPostalCode") 
	WebElement postalCode;
	
	@FindBy(css = "#address-ui-widgets-enterAddressPostalCode-full-validation-alerts > div:nth-child(1) > div:nth-child(1) > div:nth-child(2)") 
	WebElement postalCodeErrMsg;
	
	@FindBy(css = ".a-checkbox") 
	WebElement defaultAddress;
	
	@FindBy(css = "div.a-expander-container:nth-child(5)") 
	WebElement deliveryInstructions;
	
	@FindBy(css = "span.a-button-normal:nth-child(2) > span:nth-child(1) > button:nth-child(1)") 
	WebElement inApartmentDeliveryOption;
	
	@FindBy(css = "div.a-section:nth-child(21) > div:nth-child(3) > a:nth-child(1) > span:nth-child(2) > div:nth-child(1)") 
	WebElement inApartmentDeliveryOption1;

	@FindBy(css = "div.a-section:nth-child(21) > div:nth-child(3) > div:nth-child(2) > div:nth-child(2) > span:nth-child(1)") 
	WebElement securityCode;
	
	@FindBy(css = "div.a-section:nth-child(19) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(2) > span:nth-child(1) > input:nth-child(1)") 
	WebElement callBox;
	
	@FindBy(css = "div.a-section:nth-child(19) > div:nth-child(3)") 
	WebElement weekendsDeliveryOption;
	
	@FindBy(css = "div.a-section:nth-child(19) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2)") 
	WebElement deliverOnSaturday;
	
	@FindBy(css = "div.a-section:nth-child(19) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(2)") 
	WebElement deliverOnSunday;
	
	@FindBy(css = "div.a-section:nth-child(19) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1)") 
	WebElement notDeliverOnSaturday;
	
	@FindBy(css = "div.a-section:nth-child(19) > div:nth-child(3) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > ul:nth-child(1) > li:nth-child(1)") 
	WebElement notDeliverOnSunday;
	
	@FindBy(css = "#address-ui-widgets-form-submit-button > span:nth-child(1) > input:nth-child(1)") 
	WebElement addAddressButton;
	
	@FindBy(css = ".a-alert-heading")
	WebElement addressAdded;
	
	@FindBy(css = ".a-alert-heading")
	WebElement addressAlreadyExist;
	
	public PomYourAddress() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickYourAddress()
	{
		clickYourAddress.click();
	}

	public void clickAddAddress()
	{
		clickAddAddress.click();
	}
	
	public String checkCountryRegion() 
	{
		Select obj = new Select(checkCountryRegion);
		return obj.getFirstSelectedOption().getText();
	}
	
	public String enterFullName()
	{
		fullName.clear();
	    fullName.sendKeys(prop.getProperty("fullName"));
	    return fullName.getText();
	}
	
	public String enterPhoneNumber() 
	{
		phoneNumber.clear();
		phoneNumber.sendKeys(prop.getProperty("addPhoneNumber"));
		return phoneNumber.getText();
	}
	
	public String enterAddress() 
	{
		address.clear();
		address.sendKeys(prop.getProperty("addAddress"));
		return address.getText();
	}
	
	public String enterCity() 
	{
		city.clear();
		city.sendKeys(prop.getProperty("addCity"));
		return city.getText();
	}
	
	public boolean selectProvince()
	{
	    province.click();
	    selectProvince.click();
	    return selectProvince.isSelected();
	}
	
	
	public String enterPostalCode() 
	{
		postalCode.clear();
		postalCode.sendKeys(prop.getProperty("addPostalCode"));
		return postalCode.getText();
	}
	
	public void makeDefaultAddress()
	{
		defaultAddress.click();
	}
	
	public void choseDeliveryInstructions()
	{
		deliveryInstructions.click();
	}
	
	public void selectApartmentDeliveryOption()
	{
		inApartmentDeliveryOption.click();
		inApartmentDeliveryOption1.click();
	}
	
	public void enterSecurityCode() 
	{
		securityCode.sendKeys(prop.getProperty("addSecurityCode"));
	}
	
	public void enterCallBoxNumber() 
	{
		callBox.sendKeys(prop.getProperty("addCallBoxNumber"));
	}
	
	public void selectWeekendsDeliveryOption()
	{
		weekendsDeliveryOption.click();
	}
	
	public void selectDeliverOnSat()
	{
		deliverOnSaturday.click();
	}
	
	public void selectDeliverOnSun()
	{
		deliverOnSunday.click();
	}
	
	public String fullNameErrMsg() 
	{
		return fullNameErrMsg.getText();
	}
	
	public String phoneNumberErrMsg() 
	{
		return phoneNumberErrMsg.getText();
	}
	
	public String addressErrMsg() 
	{
		return addressErrMsg.getText();
	}
	
	public String cityErrMsg() 
	{
		return cityErrMsg.getText();
	}
	
	public String postalCodeErrMsg() 
	{
		return postalCodeErrMsg.getText();
	}
	
    public String provinceNotSelected()
    {
    	return provinceNotSelected.getText();
    }
	
	public void clickAddAddressButton()
	{
		
		addAddressButton.click();
	}
	
	public String addressAddedSuccessfully()
	{
		String addresAdded = addressAdded.getText();
		return addresAdded;	
	}
	
	public String addressAlreadyExist()
	{
		String addAlreadyExist = addressAlreadyExist.getText();
		return addAlreadyExist;
	}
}
