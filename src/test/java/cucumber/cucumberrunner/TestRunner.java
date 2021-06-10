package cucumber.cucumberrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features ="src/test/java/features/BigBasket.feature",
		glue="stepDefinations", plugin= {"html:target/cucumber-html-report"})
public class TestRunner {

}
