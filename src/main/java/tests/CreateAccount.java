package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.WebDriverServiceImpl;

public class CreateAccount extends WebDriverServiceImpl {

	@Test
	public void createAccount() {

		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, "DemoSalesManager");

		WebElement elePassword = locateElement("id", "password");
		type(elePassword, "crmsfa");

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

		WebElement eleAccounts = locateElement("xpath", "//a[text() = 'Accounts']");
		click(eleAccounts);


		//		Click on Create Account link
		WebElement eleCreateAcc = locateElement("link", "Create Account");
		click(eleCreateAcc);

		String accountName = "TestLeafsTestttt";
		//		Enter Account name
		WebElement eleAccName = locateElement("id", "accountName");
		type(eleAccName, accountName);

		//		Enter Currency
		WebElement eleCurrency = locateElement("id", "currencyUomId");
		type(eleCurrency, "INR - Indian Rupee");

		//		Select Industry
		WebElement eleIndustry = locateElement("name", "industryEnumId");
		type(eleIndustry, "Aerospace");

		//		Select Source
		WebElement eleSource = locateElement("id", "dataSourceId");
		type(eleSource, "Conference");

		//		Select Marketing Campaign 
		WebElement eleMktgCamp = locateElement("id", "marketingCampaignId");
		type(eleMktgCamp, "Automobile");

		//		Enter Primary number
		WebElement elePhone = locateElement("id", "primaryPhoneNumber");
		type(elePhone, "8939123367");

		//		Enter Mail ID
		WebElement eleMail = locateElement("id", "primaryEmail");
		type(eleMail, "alexanderb@gmail.com");

		//		Enter City
		WebElement eleCity = locateElement("id", "generalCity");
		type(eleCity, "Chennai");

		/*WebElement eleCreateAccount = locateElement("xpath", "//a[text() = 'Create Account']");
		click(eleCreateAccount);

		WebElement eleAccountName = locateElement("xpath", "(//input[@name = 'accountName'])[2]");
		type(eleAccountName, "Account");
		 */		
		WebElement eleCountry = locateElement("xpath", "(//select[@id = 'generalCountryGeoId'])");
		selectDropDownUsingVisibleText(eleCountry,"India");

		WebElement eleState = locateElement("xpath", "(//select[@id = 'generalStateProvinceGeoId'])");
		selectDropDownUsingVisibleText(eleState,"TAMILNADU");

		WebElement eleCreateAccountSubmit = locateElement("xpath", "(//input[@class = 'smallSubmit'])");
		click(eleCreateAccountSubmit);

		WebElement eleGetAccountNumber = locateElement("xpath", "//span [text() = 'Account Name']/following::td/span[1]");
		String compName1 = getText(eleGetAccountNumber);
		String id = compName1.replaceAll("\\D", "");
		System.out.println(id);

		WebElement eleFindAccount= locateElement("xpath", "(//a[text() = 'Find Accounts'])");
		click(eleFindAccount);

		WebElement eleFindAccountId= locateElement("xpath", "(//input [@name = 'id'])");
		type(eleFindAccountId, id);

		WebElement eleFindAccountName= locateElement("xpath", "(//input [@name = 'accountName'])[2]");
		type(eleFindAccountName,accountName );

		WebElement eleFindAccountButton= locateElement("xpath", "(//button[text() ='Find Accounts'])");
		click(eleFindAccountButton);


		WebElement eleVerifyAccountId = locateElement("xpath", "(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])");
		String getAccountId = getText(eleVerifyAccountId);

		if(getAccountId.equals(id))
		{
			System.out.println("Account Id is correct");

		}
		else
		{
			System.out.println("Account Is is not correct");
		}	
		WebElement eleVerifyAccountName = locateElement("xpath", "(//div[@class = 'x-grid3-cell-inner x-grid3-col-groupName'])");
		String getAccountName = getText(eleVerifyAccountName);
		if(getAccountName.equals(accountName))
		{
			System.out.println("Account Name is correct");
		}
		else
		{
			System.out.println("Account Name is wrong");
		}
		closeActiveBrowser();			
	}

}
