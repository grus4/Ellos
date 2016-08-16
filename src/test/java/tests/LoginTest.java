package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.PropertyLoader;


public class LoginTest extends Fixture{

    private static final String USER_NAME = PropertyLoader.loadProperty("user.name");
    private static final String PASSWORD = PropertyLoader.loadProperty("user.pass");

    @Test
    public void testForSuccessfulLogin () {
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

    //@Test
    public void testForLoginEmptyFieldsValidationError() {

        ellos.web.openPage(SITE_URL);
        //ellos.web.refreshPage();

        //click Login link at the header
        ellos.mainPage.clicLoginLink();
        ellos.loginPage.clickLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");
    }

    //@Test
    public void testForLoginInvalidDataInLoginFieldAndEmptyPasswordField() {

        ellos.web.openPage(SITE_URL);
        //ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillLoginField("rulezzzz");
        ellos.loginPage.clickLoginButton();
        Assert.assertTrue(ellos.loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");

    }

    //@Test
    public void testForLoginFormWithInvalidLoginAndPassword () {

        ellos.web.openPage(SITE_URL);
        //ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillLoginField("werwrewerwre");
        ellos.loginPage.focusOnPasswordField();
        ellos.loginPage.fillPasswordField("#$##$#%$^^");
        ellos.loginPage.clickLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");
    }

    //@Test
    public void testForLoginFormWitEmptyEmailFieldAndInvalidPassword() {

        ellos.web.openPage(SITE_URL);
        //ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillLoginField("");
        ellos.loginPage.focusOnPasswordField();
        ellos.loginPage.fillPasswordField("23wrfwoe8##$");

        ellos.loginPage.clickLoginButton();

        Assert.assertTrue(ellos.loginPage.isErrorMessageAvailable(), "Error massage is not shown in case blank Email and Password fields");

    }



}