package tests;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportss {

	public static void main(String[] args) throws IOException {
		ExtentHtmlReporter html = new ExtentHtmlReporter("./reports/result.html");
		html.setAppendExisting(true);
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(html);


		ExtentTest test = extent.createTest("testcase1", "hello world");
		test.assignCategory("Smoke");
		test.assignAuthor("Bharath");
		test.pass("The Data DemoSalesManager is Entered Successfully",
				MediaEntityBuilder.createScreenCaptureFromPath("./../snaps/snap1.jpg").build());
				extent.flush();



	}

}
