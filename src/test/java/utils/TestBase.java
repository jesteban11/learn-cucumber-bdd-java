package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.Browser;
import utils.browsers.BrowserManager;
import utils.browsers.ChromeBrowser;
import utils.browsers.EdgeBrowser;
import utils.browsers.FirefoxBrowser;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public WebDriver driver;

    public WebDriver driverManager() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/global.properties");
        Properties properties = new Properties();
        properties.load(fileInputStream);
        String url = properties.getProperty("qaUrl");
        String browserMaven = System.getProperty("browser");
        String browserProperties = properties.getProperty("browser");
        String browser = browserMaven != null ? browserMaven : browserProperties;

        String runModeMaven = System.getProperty("runMode");
        String runModeProperties = properties.getProperty("runMode");
        String runMode = runModeMaven != null ? runModeMaven : runModeProperties;

        if (driver == null) {
            BrowserManager browserManager = getBrowserFactory(browser);
            if (Boolean.parseBoolean(System.getProperty("headless"))) {
                browserManager.setHeadless();
            }
            if (runMode.equalsIgnoreCase("remote")) {
                driver = browserManager.getRemoteDriver();
            }
            if (runMode.equalsIgnoreCase("local")) {
                driver = browserManager.getLocalDriver();
            }

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
        return driver;
    }
    private BrowserManager getBrowserFactory(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                return new ChromeBrowser();
            case "firefox":
                return new FirefoxBrowser();
            case "edge":
                return new EdgeBrowser();
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
    }
}
