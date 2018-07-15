package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import lib.selenium.PreAndPost;

public class MergeLead extends PreAndPost{

	public void setValue()
	{
		testCaseName = "MergeLead";
		testDesc = "To merge the lead";
		nodeName = "Lead";
		authorName = "Bharath";
		category = "Sanity";
		excelSheetName= "MergeLead";
	}

	@Test(dataProvider = "env1")
	public void mergeLead()
	{

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
		click(locateElement("link", "Leads"));
		click(locateElement("link", "Merge Leads"));
		click(locateElement("xpath", "(//img[@alt='Lookup'])[1]"));
		switchToWindow(1);
		type(locateElement("xpath", "//input[@name='firstName']"),"bharath");
		click(locateElement("xpath", "(//button[@type='button'])[1]"));

		click(locateElement("xpath", "(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]//a)[1]"));

		switchToWindow(0);
		click(locateElement("xpath", "(//img[@alt='Lookup'])[2]"));
		switchToWindow(1);
		type(locateElement("xpath", "//input[@name='firstName']"),"gopinath");
		click(locateElement("xpath", "(//button[@type='button'])[1]"));

		click(locateElement("xpath", "(//div[contains(@class,'x-grid3-cell-inner x-grid3-col-partyId')]//a)[1]"));

		switchToWindow(0);
		click(locateElement("class", "buttonDangerous"));
		acceptAlert();
	}
}
