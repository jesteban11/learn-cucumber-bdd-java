package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
    public WebDriver driver;

    private By txtProductName = By.cssSelector("p[class='product-name']");

    private By btnPromo = By.cssSelector("[class='promoBtn']");

    private By btnPlaceOrder = By.xpath("//button[contains(text(),'Place Order')]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(txtProductName).getText();
    }

    public Boolean isPromoButtonDisplayed() {
        return driver.findElement(btnPromo).isDisplayed();
    }

    public Boolean isPlaceOrderButtonDisplayed() {
        return driver.findElement(btnPlaceOrder).isDisplayed();
    }
}
