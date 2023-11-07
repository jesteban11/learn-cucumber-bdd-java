package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
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

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            MutableCapabilities capabilities = new MutableCapabilities();
            if (Boolean.parseBoolean(System.getProperty("headless"))) {
                options.addArguments("--headless");
                options.addArguments("window-size=1920,1080");
            }
            if (browser.equalsIgnoreCase("chrome") && System.getProperty("runmode").equalsIgnoreCase("remote")) {
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "chrome");
                driver = new RemoteWebDriver(new URL("http://172.17.0.4:4444/wd/hub"), capabilities);
            }
            if (browser.equalsIgnoreCase("chrome") && System.getProperty("runmode").equalsIgnoreCase("local")) {
                //WebDriverManager.chromedriver().clearDriverCache().setup();
                driver = new ChromeDriver(options);
            }
            if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
            if (browser.equalsIgnoreCase("firefox") && System.getProperty("runmode").equalsIgnoreCase("remote")) {
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
                driver = new RemoteWebDriver(new URL("http://172.17.0.3:4444/wd/hub"), capabilities);
            }
            if (browser.equalsIgnoreCase("firefox") && System.getProperty("runmode").equalsIgnoreCase("local")) {
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
        return driver;
    }
}
