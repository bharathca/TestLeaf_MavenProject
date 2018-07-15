package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class DeleteLead extends PreAndPost{
	
	@BeforeTest
	public void setValue()
	{
		testCaseName = "DeleteLead";
		testDesc = "Delete a Lead";
		nodeName = "Lead";
		authorName = "Bharath";
		category = "Sanity";
		excelSheetName= "DeleteLead";
	}
		
	//dependsOnMethods = {"tests.CreateLead.createLead"}, alwaysRun = true
	@Test(dataProvider = "env1")
	public void deleteLead(String firstName) throws InterruptedException
	{
		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);
		
		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);

		WebElement eleLeads = locateElement("link", "Leads");
		click(eleLeads);
		
		WebElement eleFindLeads = locateElement("link", "Find Leads");
		click(eleFindLeads);
		
		Thread.sleep(5000);
		
		WebElement eleFirstName = locateElement("xpath", "(//input[@name='firstName'])[3]");
		type(eleFirstName, firstName);
		
		WebElement eleFindLeadsButton = locateElement("xpath", "//button[text()='Find Leads']");
		click(eleFindLeadsButton);
		
		WebElement eleLeadId = locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a");
		String leadID = getText(eleLeadId);
		
		click(locateElement("xpath", "//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a"));
		
		WebElement eleDelete = locateElement("link", "Delete");
		click(eleDelete);
		
	}
}
