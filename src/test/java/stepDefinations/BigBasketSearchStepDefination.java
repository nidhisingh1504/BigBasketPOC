package stepDefinations;

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
    @When("^User has given \"([^\"]*)\" on Search button and click on Search button$")
    public void user_has_given_something_on_search_button_and_click_on_search_button(String strArg1) throws Throwable {
    	System.out.println("BigBasket_page_url_is_given "+strArg1);
    }
    
    @When("^User has given Java on Search button and click on Search button$")
    public void user_has_given_java_on_search_button_and_click_on_search_button() throws Throwable {
    	System.out.println("user_has_given_java_on_search_button_and_click_on_search_button");
    }

    @Then("^User get search result$")
    public void user_get_search_result() throws Throwable {
    	System.out.println("user_get_search_result");
    }

    @And("^Java Search is there$")
    public void java_search_is_there() throws Throwable {
    	System.out.println("Java_search_is_there");
    }
    @And("^\"([^\"]*)\" Search is there$")
    public void something_search_is_there(String strArg1) throws Throwable {
    	System.out.println("Java_search_is_there "+strArg1);
    }
    @And("^Test are \"([^\"]*)\"$")
    public void test_are_something(String strArg1) throws Throwable {
    	System.out.println("Test cases are "+strArg1);
    }

}