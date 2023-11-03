package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageobjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

    public String offerPageProductName;
    public PageObjectManager pageObjectManager;

    TestContextSetup testContextSetup;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("^User searched for (.+) shortname in offers page$")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String shortName) throws InterruptedException {
        testContextSetup.pageObjectManager.landingPage().clickTopDeals();
        testContextSetup.genericUtils.switchToNewTab();
        testContextSetup.pageObjectManager.offerPage().searchItem(shortName);
        Thread.sleep(2000);
        offerPageProductName = testContextSetup.pageObjectManager.offerPage().getProductName();
    }

    @Then("Validate product name in Offers Page matches with Landing Page")
    public void validate_product_name_in_offers_page_matches_with_landing_page() {
        Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
