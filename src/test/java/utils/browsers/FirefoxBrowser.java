package utils.browsers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxBrowser implements BrowserManager {
    FirefoxOptions options;
    MutableCapabilities capabilities;

    public FirefoxBrowser() {
        options = new FirefoxOptions();
        capabilities = new MutableCapabilities();
    }

    public void setRemoteOptions() {
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
    }

    public WebDriver getRemoteDriver() throws MalformedURLException {
        setRemoteOptions();
        capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.FIREFOX.browserName());
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    public WebDriver getLocalDriver() {
        return new FirefoxDriver(options);
    }

    public void setHeadless() {
        options.addArguments("--headless");
    }
}
