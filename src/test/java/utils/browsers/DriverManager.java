package utils.browsers;

import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public interface DriverManager {
    void setHeadless();

    WebDriver getRemoteDriver() throws MalformedURLException;

    WebDriver getLocalDriver();
}
