package lib.selenium;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import data.read.ReadExcel;

public class PreAndPost extends WebDriverServiceImpl{

	public String testCaseName,testDesc,nodeName,authorName,category,excelSheetName;

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Before Suite");
		startReport();
	}



	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}



	@BeforeClass
	public void beforeClass() {
		System.out.println("BeforeClass");
		startTestCase(testCaseName, testDesc);
	}



	@Parameters({"url","userName","password"})
	@BeforeMethod
	public void beforeMethod(String url,String uName, String uPassword) {
		//for reports
		//startTestCase(testCaseName, testDesc);
		startTestModule(nodeName);
		test.assignAuthor(authorName);
		test.assignCategory(category);

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		webdriver = new ChromeDriver();
		driver = new EventFiringWebDriver(webdriver);
		driver.register(this);
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		WebElement eleUserName = locateElement("id", "username");
		type(eleUserName, uName);

		WebElement elePassword = locateElement("id", "password");
		type(elePassword, uPassword);

		WebElement eleLogin = locateElement("class", "decorativeSubmit");
		click(eleLogin);

		WebElement eleCRM = locateElement("link", "CRM/SFA");
		click(eleCRM);
	}



	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
		closeActiveBrowser();
	}



	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}



	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}



	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
		endResult();
	}

	@DataProvider(name = "env1")
	public String[][] getData() throws IOException{
		ReadExcel read = new ReadExcel();
		String[][] data = read.readExcel(excelSheetName);
		return data;
	}


}
