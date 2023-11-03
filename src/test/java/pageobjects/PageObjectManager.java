package pageobjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    public WebDriver driver;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public LandingPage landingPage() {
        return new LandingPage(driver);
    }

    public OfferPage offerPage() {
        return new OfferPage(driver);
    }

    public CheckoutPage checkoutPage() {
        return new CheckoutPage(driver);
    }
}
