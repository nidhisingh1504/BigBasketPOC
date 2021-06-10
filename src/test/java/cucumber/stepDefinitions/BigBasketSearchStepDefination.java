package cucumber.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class BigBasketSearchStepDefination {

    @Given("^BigBasket page URL is given$")
    public void BigBasket_page_url_is_given() throws Throwable {
       System.out.println("BigBasket_page_url_is_given");
    }
    @When("^User has given \"([^\"]*)\" on search box and click on search button$")
    public void user_has_given_something_on_search_box_and_click_on_search_button(String strArg1) throws Throwable {
    	System.out.println("User has given  "+strArg1);
    }
    
    @Then("^User get \"([^\"]*)\" in search result$")
    public void user_get_something_in_search_result(String strArg1) throws Throwable {
    	System.out.println("user get result "+strArg1);
    }
    
    @And("^Test are \"([^\"]*)\"$")
    public void test_are_something(String strArg1) throws Throwable {
    	System.out.println("Test cases are "+strArg1);
    }

}
