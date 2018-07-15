package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;


public class EditLead extends PreAndPost{


	@BeforeTest
	public void setValue()
	{
		testCaseName = "EditLead";
		testDesc = "To edit the current lead";
		nodeName = "Lead";
		authorName = "Bharath";
		category = "Sanity";
		excelSheetName= "EditLead";
	}

	@Test(dataProvider = "env1")
	public void editLead(String firstName, String updateCompanyName) throws InterruptedException  {

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

		WebElement eleLead = locateElement("link", "Leads");
		click(eleLead);

		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);

		WebElement eleFirstName = locateElement("xpath","(//input [@name = 'firstName'])[3]");
		type(eleFirstName, firstName);

		WebElement eleFindLeadButton= locateElement("xpath","(//button[text()='Find Leads'])");
		click(eleFindLeadButton);
		Thread.sleep(5000);


		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		click(locateElement("link", "Edit"));
		clearAndType(locateElement("id", "updateLeadForm_companyName"), updateCompanyName);
		WebElement locateElement = locateElement("id", "updateLeadForm_currencyUomId");
		selectDropDownUsingVisibleText(locateElement, "ALL - Albanian Lek");
		click(locateElement("name", "submitButton"));
		Thread.sleep(3000);
		WebElement eleFoundLead= locateElement("xpath","(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])");
		click(eleFoundLead);


		//verify title
		verifyExactTitle("View Lead | opentaps CRM");


		/*WebElement eleEdit = locateElement("link", "Edit");
		click(eleEdit);

		WebElement eleDob = locateElement("name", "birthDate");
		type(eleDob,"09/16/93");

		WebElement eleCompanyName = locateElement("xpath","(//input[@name = 'companyName'])[2]");
		type(eleCompanyName, "Mannaran Company");

		WebElement eleUpdateLead= locateElement("xpath","(//input[@name = 'submitButton'])[1]]");
		click(eleUpdateLead);*/


		/*WebElement eleVerifyCompanyName = locateElement("id", "viewLead_companyName_sp");

		WebElement elePhone = locateElement("xpath","(//span[text()='Phone'])");
		click(elePhone);

		WebElement elePhoneCountryCode = locateElement("name","phoneCountryCode");
		click(elePhoneCountryCode);
		clear(elePhoneCountryCode);


		try {
			Thread.sleep(3000);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		type(elePhoneCountryCode, "9");

		WebElement elePhoneAreaCode = locateElement("name","phoneAreaCode");
		click(elePhoneAreaCode);
		type(elePhoneAreaCode, "1");

		WebElement elePhoneNumber = locateElement("name","phoneNumber");
		click(elePhoneNumber);
		type(elePhoneNumber, "9600851656");

		WebElement eleFindLeadButton= locateElement("xpath","(//button[text()='Find Leads'])");
		click(eleFindLeadButton);*/

	}

}
