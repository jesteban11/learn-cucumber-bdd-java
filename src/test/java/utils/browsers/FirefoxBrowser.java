package utils.browsers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxBrowser {
    FirefoxOptions options;
    MutableCapabilities capabilities;

    public FirefoxBrowser() {
        options = new FirefoxOptions();
        capabilities = new MutableCapabilities();
    }

    public void setRemoteOptions(){
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
    }

    public WebDriver getRemoteDriver() throws MalformedURLException {
        setRemoteOptions();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        return new RemoteWebDriver(new URL("http://172.18.0.2:4444/wd/hub"), capabilities);
    }

    public WebDriver getLocalDriver(){
        return new FirefoxDriver(options);
    }

    public void setHeadless() {
        options.addArguments("--headless");
    }
}
