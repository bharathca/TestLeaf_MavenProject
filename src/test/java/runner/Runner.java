package runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/java/features/loginLeaftap.feature",
					glue = "tests.pageTestLeaf", 
					monochrome = true, tags="@smoke@sanity")
public class Runner {
}
