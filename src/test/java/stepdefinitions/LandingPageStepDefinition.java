package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import utils.TestContextSetup;


public class LandingPageStepDefinition {
    TestContextSetup testContextSetup;

    public LandingPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    public String offerPageProductName;

    @Given("User is on GreenCart landing page")
    public void user_is_on_green_cart_landing_page() {
        Assert.assertTrue(testContextSetup.pageObjectManager.landingPage().getTitleLandingPage().contains("GreenKart"));
    }

    @When("^User searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
        testContextSetup.pageObjectManager.landingPage().searchItem(shortName);
        Thread.sleep(2000);
        testContextSetup.landingPageProductName = testContextSetup.pageObjectManager.landingPage().getProductName().split("-")[0].trim();
        System.out.printf("%s is extracted from Home page", testContextSetup.landingPageProductName);
    }

    @When("^User Adds (.+) items to the cart$")
    public void user_adds_products_to_the_cart(int numberOfItems) {
        testContextSetup.pageObjectManager.landingPage().addNItems(numberOfItems);
        testContextSetup.pageObjectManager.landingPage().clickAddToCart();
        testContextSetup.landingPageProductName = testContextSetup.pageObjectManager.landingPage().getProductName();
        System.out.printf("%s is extracted from Home page", testContextSetup.landingPageProductName);
    }
}
