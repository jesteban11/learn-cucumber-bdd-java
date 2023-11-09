package utils.browsers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface BrowserManager {
    void setHeadless();

    WebDriver getRemoteDriver() throws MalformedURLException;

    WebDriver getLocalDriver();
}
