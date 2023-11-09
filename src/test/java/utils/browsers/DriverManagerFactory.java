package utils.browsers;

public class DriverManagerFactory {

    private static DriverManagerFactory browserManager;

    private DriverManagerFactory() {

    }

    public static DriverManagerFactory getInstance() {
        if (browserManager == null) {
            browserManager = new DriverManagerFactory();
        }
        return browserManager;
    }

    public DriverManager getBrowserDriver(String browser) {
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
