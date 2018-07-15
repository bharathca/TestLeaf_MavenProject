package pages.lead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentTest;

import lib.selenium.WebDriverServiceImpl;

public class CreateLeadPage extends WebDriverServiceImpl{

	public CreateLeadPage(/*ExtentTest test, EventFiringWebDriver driver*/)
	{
		/*this.driver = driver;
		this.test = test;*/
		PageFactory.initElements(driver, this);
	}


	@FindBy(id = "createLeadForm_companyName")
	WebElement eleCmpyName;

	@FindBy(id = "createLeadForm_firstName")
	WebElement eleFirstName;

	@FindBy(id = "createLeadForm_lastName")
	WebElement eleLastName;

	@FindBy(id = "createLeadForm_industryEnumId")
	WebElement eleIndustry;

	@FindBy(id = "createLeadForm_primaryEmail")
	WebElement eleEmail;

	@FindBy(id = "createLeadForm_primaryPhoneNumber")
	WebElement elePhoneNumber;

	@FindBy(className = "smallSubmit")
	WebElement eleCreateLead;

	@FindBy(id = "createLeadForm_primaryPhoneCountryCode")
	WebElement eleCountryCode;

	public CreateLeadPage typeCmpy(String strCmpyName)
	{
		type(eleCmpyName, strCmpyName);
		return this;
	}

	public CreateLeadPage typeFirstName(String strFirstName)
	{
		type(eleFirstName, strFirstName);
		return this;
	}

	public CreateLeadPage typeLastName(String strLastName)
	{
		type(eleLastName, strLastName);
		return this;
	}

	public CreateLeadPage selectIndustryByIndex(String indexVal)
	{
		int index = Integer.valueOf(indexVal);
		Select objSelect = new Select(eleIndustry);
		objSelect.selectByIndex(index);
		return this;
	}

	public CreateLeadPage typeCountryCode(String countryCode)
	{
		clearAndType(eleCountryCode, countryCode);
		return this;
	}
	public CreateLeadPage typePhoneNumber(String phoneNumber)
	{
		type(elePhoneNumber,phoneNumber);
		return this;
	}

	public CreateLeadPage typeEmail(String emailAddress)
	{
		type(eleEmail,emailAddress);
		return this;
	}


	public ViewLeadPage clickCreateLead()
	{
		click(eleCreateLead);
		return new ViewLeadPage(/*test, driver*/);
	}
}
