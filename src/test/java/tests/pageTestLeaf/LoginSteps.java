package tests.pageTestLeaf;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {
	public static ChromeDriver driver;

	@Given("Open the browser")
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	@And("Launch the URL")
	public void launchUrl()
	{
		driver.get("http://leaftaps.com/opentaps/control/login");
	}
	@And("Set the timeouts")
	public void setTimeOuts()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	@And("Maximize the browser")
	public void maximizeWindow()
	{
		driver.manage().window().maximize();
	}

	@And("Enter the user as (.*)")
	public void userName(String userName)
	{
		driver.findElementById("username").sendKeys(userName);
	}

	@And("Enter the password as (.*)")
	public void password(String password)
	{
		driver.findElementById("password").sendKeys(password);
	}

	@When("Click on the Login Button")
	public void login()
	{
		driver.findElementByClassName("decorativeSubmit").click();
	}
	@Then("Login should be successful")
	public void success()
	{
		System.out.println("Login is successful");
	}

	@Given("Click on the CRM\\/SFA Link")
	public void clickCRMSFA() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElementByLinkText("CRM/SFA").click();

	}
	@And("Click on the Lead tab")
	public void leadTab()
	{
		driver.findElementByLinkText("Leads").click();
	}

	@And("Click on the Create Lead")
	public void createLead()
	{
		driver.findElementByLinkText("Create Lead").click();
	}
	@And("Enter Company Name as (.*)")
	public void companyName(String companyName)
	{
		driver.findElementByXPath("(//input[@name = 'companyName'])[2]").sendKeys(companyName);
	}

	@And("Enter the First Name as (.*)")
	public void firstName(String firstName)
	{
		driver.findElementByXPath("(//input[@name = 'firstName'])[3]").sendKeys(firstName);
	}

	@And("Enter the Last Name as (.*)")
	public void lastName(String lastName)
	{
		driver.findElementByXPath(("(//input[@name = 'lastName'])[3]")).sendKeys(lastName);
	}
	@When("Click on the Create Lead Button")
	public void createLeadClick()
	{
		driver.findElementByClassName("smallSubmit").click();
	}
	@Then("Lead should be created")
	public void verifyLeadIsCreated()
	{
		System.out.println("Lead is created is successfully");
	}

}
