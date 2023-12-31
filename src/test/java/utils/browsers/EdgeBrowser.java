package utils.browsers;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class EdgeBrowser implements DriverManager {
    EdgeOptions options;
    MutableCapabilities capabilities;

    public EdgeBrowser() {
        options = new EdgeOptions();
        capabilities = new MutableCapabilities();
    }

    public void setHeadless() {
        options.addArguments("--headless");
    }

    public WebDriver getRemoteDriver() throws MalformedURLException {
        capabilities.setCapability(EdgeOptions.CAPABILITY, options);
        capabilities.setCapability(CapabilityType.BROWSER_NAME, Browser.EDGE.browserName());
        return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);
    }

    public WebDriver getLocalDriver() {
        options.addArguments("window-size=1920,1080");
        return new EdgeDriver(options);
    }
}
