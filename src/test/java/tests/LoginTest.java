package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import utils.NoElementFound;
import utils.PropertyLoader;
import utils.WebElementsActions;



public class LoginTest extends Fixture{

    private static final String USER_NAME = PropertyLoader.loadProperty("user.name");
    private static final String PASSWORD = PropertyLoader.loadProperty("user.pass");

    @Test
    public void testForSuccessfulLogin () throws Exception {

        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillLoginField(USER_NAME);
        ellos.loginPage.focusOnPasswordField();
        ellos.loginPage.fillPasswordField(PASSWORD);
        ellos.loginPage.clickLoginButton();
        Assert.assertTrue(ellos.mainPage.isLogoutLinkAvailable(),"The user is not logged in");
        ellos.mainPage.clickLogoutLink();
    }

    @Test
    public void testForLoginEmptyFieldsValidationError() throws Exception {

        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        //click Login link at the header
        ellos.mainPage.clicLoginLink();
        ellos.loginPage.clickLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");
    }

    @Test
    public void testForLoginInvalidDataInLoginFieldAndEmptyPasswordField() throws Exception {

        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillLoginField("rulezzzz");
        ellos.loginPage.clickLoginButton();
        Assert.assertTrue(ellos.loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");

    }

    @Test
    public void testForLoginFormWithInvalidLoginAndPassword () throws Exception {

        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillLoginField("werwrewerwre");
        ellos.loginPage.focusOnPasswordField();
        ellos.loginPage.fillPasswordField("#$##$#%$^^");
        ellos.loginPage.clickLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");
    }

    @Test
    public void testForLoginFormWitEmptyEmailFieldAndInvalidPassword() throws NoElementFound {

        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillLoginField("");
        ellos.loginPage.focusOnPasswordField();
        ellos.loginPage.fillPasswordField("23wrfwoe8##$");

        ellos.loginPage.clickLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");

    }



}