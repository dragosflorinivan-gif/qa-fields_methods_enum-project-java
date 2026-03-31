public class BrowserConfig {
    // Private fields
    private BrowserType browser;
    private String version;
    private boolean isHeadless;

    // BrowserConfig constructor with 3 parameters
    public BrowserConfig(BrowserType browser, String version, boolean isHeadless) {
        this.browser = browser;
        this.version = version;
        this.isHeadless = isHeadless;

    }

    // BrowserConfig constructor with 2 parameters
    public BrowserConfig(BrowserType browser, String version) {
        this(browser, version, false);
    }

    // BrowserConfig constructor with 1 parameter
    public BrowserConfig(BrowserType browser) {
        this(browser, "latest", false); 
    }


    //  Static factory method
    public static BrowserConfig createDefaultChromeConfig() {
        return new BrowserConfig(BrowserType.CHROME, "latest", true);
    }

    //  Instance method to display configuration
    public void afiseazaConfig() {
        System.out.println(
                "Detalii BrowserConfig:" +
                        "\n  - Browser: " + this.browser +
                        "\n  - Version: " + this.version +
                        "\n  - isHeadless: " + this.isHeadless);
    }
}