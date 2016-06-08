import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.SuccessfulRegistrationPage;
import random.RandomUser;
import utils.WebElementsActions;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private static WebDriver driver;
    private static WebElementsActions web;
    private String baseUrl = "http://www.ellos.se/";
    private String randomUser = RandomUser.randomEmail();
    private String password = "123456";

    @BeforeClass
    public static void setUp(){
        driver = new FirefoxDriver();
        web = new WebElementsActions(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void SuccessfulRegistrationNewUserTest() throws Exception {
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        //click Login link
        mainPage.clicLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        SuccessfulRegistrationPage successfulRegistrationPage = new SuccessfulRegistrationPage(driver);

        //fill out Email field
        loginPage.fillEmailRegistrationField(randomUser);
        //fill out repeat email field
        loginPage.fillRepeatRegistrationEmailField(randomUser);
        //loginPage.focusOnRegistrationPasswordField();
        //fill out password field
        loginPage.clearRegistrationPasswordFiled();
        loginPage.fillPasswordRegistrationField(password);

        //loginPage.focusOnRepeatRegistrationPasswordField();
        //fill out repeat password field
        loginPage.clearRepeatRegistrationPasswordFiled();
        loginPage.fillRepeatRegistrationPasswordField(password);
        //click on registration button
        loginPage.clickRegistrationButton();

        //verify successfull registration message
        Assert.assertTrue("Registration is not successful",successfulRegistrationPage.isRegistrationSuccessful());

    }

    @Test
    public void EmptyFieldsValidationForRegistrationFormTest() throws Exception {
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        //click Login link
        mainPage.clicLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        SuccessfulRegistrationPage successfulRegistrationPage = new SuccessfulRegistrationPage(driver);

        //leave empty email fields
        //click on registration button
        loginPage.clickRegistrationButton();

        //verify error messages block

        Assert.assertTrue("Error message is not shown", loginPage.isEmptyFieldsErrorMessageForRgeistrationFormAvailable());
    }

    @Test
    public void incorrectDatainTheFirstEmailFieldTest () throws Exception{
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        //click Login link
        mainPage.clicLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        SuccessfulRegistrationPage successfulRegistrationPage = new SuccessfulRegistrationPage(driver);

        //fill out Email field
        loginPage.fillEmailRegistrationField("erqwirwrqwrq");
        //fill out repeat email field
        loginPage.fillRepeatRegistrationEmailField(randomUser);
        //loginPage.focusOnRegistrationPasswordField();
        //fill out password field
        loginPage.clearRegistrationPasswordFiled();
        loginPage.fillPasswordRegistrationField(password);

        //loginPage.focusOnRepeatRegistrationPasswordField();
        //fill out repeat password field
        loginPage.clearRepeatRegistrationPasswordFiled();
        loginPage.fillRepeatRegistrationPasswordField(password);
        //click on registration button
        loginPage.clickRegistrationButton();

        //verify error messages block
        Assert.assertTrue("Error message is not shown", loginPage.isEmptyFieldsErrorMessageForRgeistrationFormAvailable());

    }

    @Test
    public void incorrectDatainTheSecondEmailFieldTest () throws Exception{
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        //click Login link
        mainPage.clicLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        SuccessfulRegistrationPage successfulRegistrationPage = new SuccessfulRegistrationPage(driver);

        //fill out Email field
        loginPage.fillEmailRegistrationField(randomUser);
        //fill out repeat email field
        loginPage.fillRepeatRegistrationEmailField("erqwirwrqwrq");
        //loginPage.focusOnRegistrationPasswordField();
        //fill out password field
        loginPage.clearRegistrationPasswordFiled();
        loginPage.fillPasswordRegistrationField(password);

        //loginPage.focusOnRepeatRegistrationPasswordField();
        //fill out repeat password field
        loginPage.clearRepeatRegistrationPasswordFiled();
        loginPage.fillRepeatRegistrationPasswordField(password);
        //click on registration button
        loginPage.clickRegistrationButton();

        //verify error messages block
        Assert.assertTrue("Error message is not shown",loginPage.isEmptyFieldsErrorMessageForRgeistrationFormAvailable());

    }

    @Test
    public void registerTheSameUserTest() throws Exception {
        //open http://www.ellos.se/
        web.openPage(baseUrl);
        web.refreshPage();

        MainPage mainPage = new MainPage(driver);
        //click Login link
        mainPage.clicLoginLink();

        LoginPage loginPage = new LoginPage(driver);
        SuccessfulRegistrationPage successfulRegistrationPage = new SuccessfulRegistrationPage(driver);

        //fill out Email field
        loginPage.fillEmailRegistrationField("rulezz234@ukr.net");
        //fill out repeat email field
        loginPage.fillRepeatRegistrationEmailField("rulezz234@ukr.net");
        //loginPage.focusOnRegistrationPasswordField();
        //fill out password field
        loginPage.clearRegistrationPasswordFiled();
        loginPage.fillPasswordRegistrationField(password);

        //loginPage.focusOnRepeatRegistrationPasswordField();
        //fill out repeat password field
        loginPage.clearRepeatRegistrationPasswordFiled();
        loginPage.fillRepeatRegistrationPasswordField(password);
        //click on registration button
        loginPage.clickRegistrationButton();

        Assert.assertTrue("Errror message is not shown", loginPage.isErrorMessageAvailable());
    }




    @AfterClass
    public static void tearDown() throws Exception {
        driver.quit();
    }


}
