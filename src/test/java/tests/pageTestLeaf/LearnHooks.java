package tests.pageTestLeaf;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import lib.selenium.WebDriverServiceImpl;

public class LearnHooks extends WebDriverServiceImpl{
@Before
public void beforeScenario(Scenario scenario)
{
	startReport();
	startTestCase(scenario.getName(), scenario.getId());
	//startTestModule(/*nodeName*/);
	test.assignAuthor("Bharath");
	test.assignCategory("Sanity");
}

@After
public void afterScenario(Scenario scenario)
{
	System.out.println(scenario.getStatus());
	System.out.println(scenario.isFailed());
}
}
