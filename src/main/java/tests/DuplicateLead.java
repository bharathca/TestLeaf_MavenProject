package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class DuplicateLead extends PreAndPost{

	public void setValue()
	{
		testCaseName = "DuplicateLead";
		testDesc = "To duplicate the lead";
		nodeName = "Lead";
		authorName = "Bharath";
		category = "Sanity";
		excelSheetName= "DuplicateLead";
	}
	
	@Test(dataProvider = "env1")
	public void duplicateLead(String emailAddress, String title, String updateCompanyName) throws InterruptedException {

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

		WebElement eleLead = locateElement("link", "Leads");
		click(eleLead);

		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);

		WebElement eleEmail = locateElement("xpath","(//span[text()='Email'])");
		click(eleEmail);

		WebElement eleEmailAddress = locateElement("name","emailAddress");
		click(eleEmailAddress);
		type(eleEmailAddress, emailAddress);

		WebElement eleFindLeadButton= locateElement("xpath","(//button[text()='Find Leads'])");
		click(eleFindLeadButton);

		Thread.sleep(3000);

		WebElement eleFoundLead= locateElement("xpath","(//div[@class = 'x-grid3-cell-inner x-grid3-col-partyId'])");
		click(eleFoundLead);

		Thread.sleep(3000);

		WebElement eleDuplicateLead= locateElement("xpath","(//a[text()='Duplicate Lead'])");
		click(eleDuplicateLead);

		Thread.sleep(3000);
		verifyPartialTitle(title);

		WebElement eleCompanyName = locateElement("xpath","(//input[@name = 'companyName'])[2]");
		clearAndType(eleCompanyName, ""+updateCompanyName);

		WebElement eleCreateLead = locateElement("class", "smallSubmit");
		click(eleCreateLead);
	}
}
