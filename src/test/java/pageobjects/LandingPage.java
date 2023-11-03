package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    private By search = By.cssSelector("[type=search]");
    private By productName = By.cssSelector("h4.product-name");
    private By btnTopdeals = By.xpath("//a[contains(text(),'Deals')]");

    private By btnAddToCart = By.cssSelector("[class='product-action'] button");

    private By btnAdd = By.cssSelector("[class='increment']");

    private By btnCart = By.cssSelector("[class='cart-icon']");
    private By btnProceedCheckout = By.cssSelector("[class='action-block'] button");

    public void searchItem(String name) {
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }

    public void clickTopDeals() {
        driver.findElement(btnTopdeals).click();
    }

    public void addNItems(int number) {
        for (int i = 1; i < number; i++) {
            driver.findElement(btnAdd).click();
        }
    }

    public void clickAddToCart() {
        driver.findElement(btnAddToCart).click();
    }

    public CheckoutPage clickCartButton() {
        driver.findElement(btnCart).click();
        driver.findElement(btnProceedCheckout).click();
        return new CheckoutPage(driver);
    }

    public String getTitleLandingPage(){
        return driver.getTitle();
    }
}
