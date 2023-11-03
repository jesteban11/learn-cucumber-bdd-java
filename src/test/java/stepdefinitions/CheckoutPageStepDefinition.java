package stepdefinitions;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
    TestContextSetup testContextSetup;

    public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("Validate product name in Checkout Page matches with Landing Page")
    public void validate_product_name_in_checkout_page_matches_with_landing_page() {
        testContextSetup.pageObjectManager.landingPage().clickCartButton();
        String checkoutProductName = testContextSetup.pageObjectManager.checkoutPage().getProductName();
        Assert.assertEquals(testContextSetup.landingPageProductName, checkoutProductName);
    }

    @Then("verify user has the ability to enter promo code and place the order")
    public void apply_button_and_place_order_button_are_present() {
        Assert.assertTrue(testContextSetup.pageObjectManager.checkoutPage().isPromoButtonDisplayed());
        Assert.assertTrue(testContextSetup.pageObjectManager.checkoutPage().isPlaceOrderButtonDisplayed());
    }
}
