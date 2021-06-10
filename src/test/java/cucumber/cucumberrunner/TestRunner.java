package cucumber.cucumberrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/java/cucumber/features/BigBasket.feature",
		glue="stepDefinations")
public class TestRunner {

}
