public class TestConfigRunner {
    public static void main(String[] args) {
        //  Instance using constructor with 3 parameters
        BrowserConfig c1 = new BrowserConfig(BrowserType.CHROME, "146.0", true);

        //  Instance using constructor with 2 parameters
        BrowserConfig c2 = new BrowserConfig(BrowserType.FIREFOX, "149.0");

        //  Instance using constructor with 1 parameter
        BrowserConfig c3 = new BrowserConfig(BrowserType.EDGE);

        //  Instance using static method factory
        BrowserConfig c4 = BrowserConfig.createDefaultChromeConfig();

        // Display configurations
        System.out.println("----- CONFIG 1 -----");
        c1.afiseazaConfig();

        System.out.println("----- CONFIG 2 ------");
        c2.afiseazaConfig();

        System.out.println("----- CONFIG 3 -----");
        c3.afiseazaConfig();

        System.out.println("----- CONFIG 4 (Factory) -----");
        c4.afiseazaConfig();
    }
}