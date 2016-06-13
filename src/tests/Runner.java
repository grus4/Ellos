package tests;

import org.apache.log4j.Logger;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import java.util.concurrent.TimeUnit;


@RunWith(Suite.class)
@SuiteClasses({
        LoginTest.class,
        RegistrationTest.class,
        ProductPageTest.class
})
public class Runner {
    static WebDriver driver;
    private static final Logger log = Logger.getLogger(Runner.class);

    @BeforeClass
    public static void setUp() throws Exception {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        log.info("Start Test Suite execution");
    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
        log.info("Tests Suite execution completed.");
    }


}
