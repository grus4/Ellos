package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.Ellos;
import utils.ClassNameUtil;
import utils.PropertyLoader;
import utils.WebDriverWrapper;



import java.util.concurrent.TimeUnit;


public class Fixture {
    static WebDriverWrapper driver;
    public static Ellos ellos;
    private static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public static final String SITE_URL = PropertyLoader.loadProperty("site.url");
    private static final String IMPLICIT_WAIT = PropertyLoader.loadProperty("wait.timeout");



    @BeforeSuite
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
        driver = new WebDriverWrapper(new ChromeDriver());
        ellos = new Ellos(driver);
        driver.manage().timeouts().implicitlyWait(Long.parseLong(IMPLICIT_WAIT), TimeUnit.SECONDS);
        log.info("Start Test Suite execution");
    }

    @AfterSuite
    public static void tearDown() throws Exception {
        driver.quit();
        log.info("Tests Suite execution completed.");
    }


}
