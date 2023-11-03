package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {

    private By search = By.cssSelector("[type=search]");
    private By productName = By.cssSelector("tr td:nth-child(1)");
    public WebDriver driver;

    public OfferPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchItem(String name) {
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
}
