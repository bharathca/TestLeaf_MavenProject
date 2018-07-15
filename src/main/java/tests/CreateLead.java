package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import lib.selenium.PreAndPost;


public class CreateLead extends PreAndPost{
	@BeforeTest
	public void setValue()
	{
		testCaseName = "CreateLead";
		testDesc = "Create a New Lead";
		nodeName = "Lead";
		authorName = "Bharath";
		category = "Sanity";
		excelSheetName= "CreateLead";
	}
	
	@Test(dataProvider = "env1")
	public void createLead(String companyName, String firstName, String lastName, String email, String phoneNumber) {
	

		WebElement eleCreateLeadClick = locateElement("link", "Create Lead");
		click(eleCreateLeadClick);

		WebElement eleCompanyName = locateElement("xpath","(//input[@name = 'companyName'])[2]");
		type(eleCompanyName, ""+companyName);


		WebElement eleFirstName = locateElement("xpath","(//input[@name = 'firstName'])[3]");
		type(eleFirstName, ""+firstName);

		WebElement eleLastName = locateElement("xpath","(//input[@name = 'lastName'])[3]");
		type(eleLastName, ""+lastName);
		
		WebElement pEmail = locateElement("id", "createLeadForm_primaryEmail");
		type(pEmail,email);
		WebElement pPhoneNumber = locateElement("id", "createLeadForm_primaryPhoneNumber");
		type(pPhoneNumber,phoneNumber);

		WebElement eleCreateLead = locateElement("class", "smallSubmit");
		click(eleCreateLead);

		/*String id1 = getText(locateElement("id", "viewLead_companyName_sp"));
        String leadID1 = id1.replaceAll("\\D+", "");
        System.out.println(leadID1);
        System.out.println(driver.getTitle());
        */
	/*	WebElement eleGetAccountNumber = locateElement("xpath", "//span [text() = 'Account Name']/following::td/span[1]");
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
		
				WebElement eleSource = locateElement("id", "createLeadForm_dataSourceId");
		selectDropDownUsingIndex(eleSource, 5);

		WebElement eleMarCamp = locateElement("id", "createLeadForm_marketingCampaignId");
		selectDropDownUsingVisibleText(eleMarCamp, "Catalog Generating Marketing Campaigns");

		WebElement eleReadCompany = locateElement("id","viewLead_companyName_sp");
		String compName = getText(eleReadCompany);
		String s1=compName.substring(compName.lastIndexOf('(')+1, compName.lastIndexOf(')'));
		 

		WebElement eleCreateLead = locateElement("class", "smallSubmit");
		click(eleCreateLead);


*/
	}
}




