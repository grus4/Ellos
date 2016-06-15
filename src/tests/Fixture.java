package tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import java.util.concurrent.TimeUnit;


public class Fixture {
    static WebDriver driver;
    private static final Logger log = Logger.getLogger(Fixture.class);

    @BeforeSuite
    public static void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        log.info("Start Test Suite execution");
    }

    @AfterSuite
    public static void tearDown() throws Exception {
        driver.quit();
        log.info("Tests Suite execution completed.");
    }


}
