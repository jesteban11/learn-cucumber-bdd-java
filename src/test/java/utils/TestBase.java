package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

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

        if (driver == null) {
            ChromeOptions options = new ChromeOptions();
            if (Boolean.parseBoolean(System.getProperty("headless"))) {
                options.addArguments("--headless");
                options.addArguments("window-size=1920,1080");
            }
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().clearDriverCache().setup();
                driver = new ChromeDriver(options);
            }
            if (browser.equalsIgnoreCase("edge")) {
                driver = new EdgeDriver();
            }
            if (browser.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().clearDriverCache().setup();
                driver = new FirefoxDriver();
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.get(url);
        }
        return driver;
    }
}
