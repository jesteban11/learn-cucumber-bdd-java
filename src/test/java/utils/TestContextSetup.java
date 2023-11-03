package utils;

import org.openqa.selenium.WebDriver;
import pageobjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup {
    public String landingPageProductName;

    public PageObjectManager pageObjectManager;
    public TestBase testBase;

    public GenericUtils genericUtils;

    public TestContextSetup() throws IOException {
        testBase = new TestBase();
        pageObjectManager = new PageObjectManager(testBase.driverManager());
        genericUtils = new GenericUtils(testBase.driverManager());
    }
}
