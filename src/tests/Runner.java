import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.WebElementsActions;

import java.util.concurrent.TimeUnit;


@RunWith(Suite.class)
@SuiteClasses({
        LoginTest.class,
        RegistrationTest.class,
        ProductPageTest.class
})
public class Runner {
    public static  WebElementsActions web;
    public static WebDriver driver;
    private static final Logger log = Logger.getLogger(Runner.class);
    public static final String baseUrl = "http://www.ellos.se/";

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        web = new WebElementsActions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        log.info("Start Test Suite execution");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        log.info("Tests Suite execution completed.");
    }


}
