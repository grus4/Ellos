import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.MainPage;
import utils.NoElementFound;
import utils.WebElementsActions;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;



public class LoginTest {
    private static WebDriver driver;
    private static WebElementsActions web;
    private String baseUrl = "http://www.ellos.se/";


    @BeforeClass
    public static void setUp() throws Exception {
        driver = new FirefoxDriver();
        web = new WebElementsActions(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }


    @Test
    public void testForSuccessfulLogin () throws Exception {
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clicLoginLink();

        LoginPage loginPage = new LoginPage(driver);

        /*
        * Fill out a Login field with invalid data
        * */
        loginPage.fillLoginField("rulezz234@ukr.net");

        /*
        * Fill out a password field with invalid data
        * */
        loginPage.focusOnPasswordField();
        loginPage.fillPasswordField("789987123life");

        //driver.findElement(By.xpath(".//input[@id='LoginPasswordText']")).clear();

        loginPage.clickLoginButton();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        Assert.assertTrue("The user is not logged in", mainPage.isLogoutLinkAvailable());


        mainPage.clickLogoutLink();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


    }

    @Test
    public void testForLoginEmptyFieldsValidationError() throws Exception {
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();


        //create object of Main Page
        MainPage mainPage = new MainPage(driver);

        //click Login link at the header
        mainPage.clicLoginLink();

        //create object of Login Page
        LoginPage loginPage = new LoginPage(driver);
        //leave empty login and password fields and click Login button
        loginPage.clickLoginButton();

        Assert.assertTrue("Error massage is not shown in case blank Email and Password fields", loginPage.isErrorMessageAvailable());
    }
    @Test
    public void testForLoginInvalidDataInLoginFieldAndEmptyPasswordField() throws Exception {
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();


        //create object of Main Page
        MainPage mainPage = new MainPage(driver);

        //click Login link at the header
        mainPage.clicLoginLink();

        //create object of Login Page
        LoginPage loginPage = new LoginPage(driver);

        //fill in yhe login field with invalid data and leave empty the password field
        loginPage.fillLoginField("rulezzzz");

        //click the login button
        loginPage.clickLoginButton();

        Assert.assertTrue("Error massage is not shown in case blank Email and Password fields", loginPage.isErrorMessageAvailable());
        //System.out.println(isElementPresent(By.xpath(".//div[@id='ctl00_ctl00_conMain_conMain_LoginControl_pnl' and @class='boxFrameError']")));

    }

    @Test
    public void testForLoginFormWithInvalidLoginAndPassword () throws Exception {
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clicLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        /*
        * Fill out a Login field with invalid data
        * */
        loginPage.fillLoginField("werwrewerwre");
        /*
        * Fill out a password field with invalid data
        * */
        loginPage.focusOnPasswordField();
        loginPage.fillPasswordField("#$##$#%$^^");

        /*
        * Click the Login button
        * */
        loginPage.clickLoginButton();

        Assert.assertTrue("Error massage is not shown in case blank Email and Password fields", loginPage.isErrorMessageAvailable());
    }

    @Test
    public void testForLoginFormWitEmptyEmailFieldAndInvalidPassword() throws NoElementFound {
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);

        //click the login link at the header
        mainPage.clicLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginField("");
        loginPage.focusOnPasswordField();
        loginPage.fillPasswordField("23wrfwoe8##$");

        loginPage.clickLoginButton();

        Assert.assertTrue("Error massage is not shown in case blank Email and Password fields", loginPage.isErrorMessageAvailable());

    }

    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by).isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }



}