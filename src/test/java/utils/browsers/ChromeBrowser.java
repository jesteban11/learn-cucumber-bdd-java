package utils.browsers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeBrowser {
    ChromeOptions options;
    MutableCapabilities capabilities;

    public ChromeBrowser() {
        options = new ChromeOptions();
        capabilities = new MutableCapabilities();
    }

    public void setRemoteOptions() {
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
    }

    public void setHeadless() {
        options.addArguments("--headless");
    }

    public WebDriver getLocalDriver() {
        options.addArguments("window-size=1920,1080");
        return new ChromeDriver(options);
    }

    public WebDriver getRemoteDriver() throws MalformedURLException {
        setRemoteOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.CHROME.browserName());
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }
}
