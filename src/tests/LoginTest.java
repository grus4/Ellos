package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.NoElementFound;
import utils.WebElementsActions;



public class LoginTest {

    private WebDriver driver = Fixture.driver;
    private WebElementsActions web = new WebElementsActions(driver);
    private static final String baseUrl = "http://www.ellos.se/";

    @Test
    public void testForSuccessfulLogin () throws Exception {
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        mainPage.clicLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        //Fill out a Login field with invalid data
        loginPage.fillLoginField("rulezz234@ukr.net");
        //Fill out a password field with invalid data
        loginPage.focusOnPasswordField();
        loginPage.fillPasswordField("789987123life");
        loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isLogoutLinkAvailable(),"The user is not logged in");
        mainPage.clickLogoutLink();
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

        Assert.assertTrue(loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");
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
        Assert.assertTrue(loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");

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

        Assert.assertTrue(loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");
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

        Assert.assertTrue(loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");

    }



}