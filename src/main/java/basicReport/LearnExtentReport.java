package basicReport;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class LearnExtentReport {

	public static void main(String[] args) throws IOException {
		
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);
		html.loadXMLConfig("./src/main/resources/extent-config.xml");
		
		ExtentTest testSuite = extent.createTest("TC001_CreateLeat", "Create a new Lead in leaftaps");
		ExtentTest test = testSuite.createNode("Leads");
		test.assignCategory("smoke");
		test.assignAuthor("sarath");
		
		test.pass("The Data DemoSalesManager is Entered Successfully",
				MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
		
		test.fail("The Data crmsfa is Entered Successfully");
		test.pass("The Login button is clicked Successfully");
		extent.flush();

	}










}
