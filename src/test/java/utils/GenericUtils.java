package utils;

import org.openqa.selenium.WebDriver;

import java.util.Set;

public class GenericUtils {
    public WebDriver driver;

    public GenericUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToNewTab() {
        Set<String> windows = driver.getWindowHandles();
        windows.forEach(driver.switchTo()::window);
    }
}
