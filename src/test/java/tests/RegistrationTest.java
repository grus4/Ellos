package tests;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SuccessfulRegistrationPage;
import random.RandomUser;
import utils.WebElementsActions;

public class RegistrationTest extends Fixture{

    private String randomUser = RandomUser.randomEmail();
    private String password = "123456";


    @Test
    public void SuccessfulRegistrationNewUserTest() throws Exception {

        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillEmailRegistrationField(randomUser);
        ellos.loginPage.fillRepeatRegistrationEmailField(randomUser);
        ellos.loginPage.clearRegistrationPasswordFiled();
        ellos.loginPage.fillPasswordRegistrationField(password);
        ellos.loginPage.clearRepeatRegistrationPasswordFiled();
        ellos.loginPage.fillRepeatRegistrationPasswordField(password);
        ellos.loginPage.clickRegistrationButton();

        //verify successfull registration message
        Assert.assertTrue(ellos.successfulRegistrationPage.isRegistrationSuccessful(), "Registration is not successful");

    }

    @Test
    public void EmptyFieldsValidationForRegistrationFormTest() throws Exception {
        //open http://www.ellos.se/
        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        //leave empty email fields
        //click on registration button
        ellos.loginPage.clickRegistrationButton();

        //verify error messages block
        Assert.assertTrue(ellos.loginPage.isEmptyFieldsErrorMessageForRgeistrationFormAvailable(), "Error message is not shown");
    }

    @Test
    public void incorrectDatainTheFirstEmailFieldTest () throws Exception{
        //open http://www.ellos.se/
        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillEmailRegistrationField("erqwirwrqwrq");
        ellos.loginPage.fillRepeatRegistrationEmailField(randomUser);
        ellos.loginPage.clearRegistrationPasswordFiled();
        ellos.loginPage.fillPasswordRegistrationField(password);

        ellos.loginPage.clearRepeatRegistrationPasswordFiled();
        ellos.loginPage.fillRepeatRegistrationPasswordField(password);
        ellos.loginPage.clickRegistrationButton();

        //verify error messages block
        Assert.assertTrue(ellos.loginPage.isEmptyFieldsErrorMessageForRgeistrationFormAvailable(), "Error message is not shown");

    }

    @Test
    public void incorrectDatainTheSecondEmailFieldTest () throws Exception{
        //open http://www.ellos.se/
        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillEmailRegistrationField(randomUser);
        ellos.loginPage.fillRepeatRegistrationEmailField("erqwirwrqwrq");
        ellos.loginPage.clearRegistrationPasswordFiled();
        ellos.loginPage.fillPasswordRegistrationField(password);

        ellos.loginPage.clearRepeatRegistrationPasswordFiled();
        ellos.loginPage.fillRepeatRegistrationPasswordField(password);
        ellos.loginPage.clickRegistrationButton();

        //verify error messages block
        Assert.assertTrue(ellos.loginPage.isEmptyFieldsErrorMessageForRgeistrationFormAvailable(), "Error message is not shown");

    }

    @Test
    public void registerTheSameUserTest() throws Exception {
        //open http://www.ellos.se/
        ellos.web.openPage(SITE_URL);
        ellos.web.refreshPage();

        ellos.mainPage.clicLoginLink();

        ellos.loginPage.fillEmailRegistrationField("rulezz234@ukr.net");
        ellos.loginPage.fillRepeatRegistrationEmailField("rulezz234@ukr.net");
        ellos.loginPage.clearRegistrationPasswordFiled();
        ellos.loginPage.fillPasswordRegistrationField(password);
        ellos.loginPage.clearRepeatRegistrationPasswordFiled();
        ellos.loginPage.fillRepeatRegistrationPasswordField(password);
        ellos.loginPage.clickRegistrationButton();

        Assert.assertTrue(ellos.loginPage.isErrorMessageAvailable(), "Errror message is not shown");
    }



}
