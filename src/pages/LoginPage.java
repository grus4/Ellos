package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.LocatorsParser;
import utils.NoElementFound;
import utils.WebElementsActions;

/**
 * Created by user on 5/29/2016.
 */
public class LoginPage {

    private WebElementsActions web;
    public static final Logger log = Logger.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }

    public void fillLoginField(String email) throws NoElementFound {
        web.input("LoginEmailField",email);
        log.info("Login Email field was filled out");

    }

    public void fillPasswordField(String password) throws NoElementFound{
            web.input("PasswordField", password);
            log.info("Password field was filled out");

    }

    public void focusOnPasswordField() throws NoElementFound{
                web.clickElement("PasswordFieldPlaceholder");
                log.info("Password field was clicked");

    }

    public void clickLoginButton() throws NoElementFound{
            web.clickButton("LoginButton");
            log.info("Login Button was clicked");

    }

    public void fillEmailRegistrationField(String emailRegistration) throws NoElementFound{
            web.input("RegistrationEmailField", emailRegistration);
            log.info("Registration Email field was filled out");

    }

    public void fillRepeatRegistrationEmailField(String repeatEmailRegistration) throws NoElementFound{
            web.input("RegistrationRepeatEmailField", repeatEmailRegistration);
            log.info("Repeat Email field was filled out");

    }

    public void focusOnRegistrationPasswordField() throws NoElementFound{
            web.clickElement("RegistrationPasswordPlaceholder");
            log.info("Registration Password field was clicked");

    }

    public void clearRegistrationPasswordFiled() throws NoElementFound{
            web.clearField("RegistrationPasswordPlaceholder");
            log.info("Registration password placeholder was cleaned");

    }



    public void focusOnRepeatRegistrationPasswordField() throws NoElementFound{
            web.clickElement("RegistrationRepeatPasswordPlaceholder");
            log.info("Repeat Registration Password field was clicked");

    }

    public void clearRepeatRegistrationPasswordFiled() throws NoElementFound{
            web.clearField("RegistrationRepeatPasswordPlaceholder");
            log.info("Registration password placeholder was cleaned");

    }

    public void fillPasswordRegistrationField(String passworRegistrationField) throws NoElementFound{
            web.inputWithoutClean("RegitrationPasswordField", passworRegistrationField);
            log.info("Registartion password field was filled out");

    }

    public void fillRepeatRegistrationPasswordField(String repeatRegistrationPasswordField) throws NoElementFound{
            web.inputWithoutClean("RepeatRegistrationPasswordField", repeatRegistrationPasswordField);
            log.info("Repeat Registration password field was filled out");

    }

    public void clickRegistrationButton() throws NoElementFound{
            web.windowScroll();
            web.clickButton("RegistrationButton");
            log.info("Registration Button was pressed");

    }

    public boolean isErrorMessageAvailable() throws NoElementFound {

            if (web.isElementPresent("ErrorMessageBlock") && web.isElementAvailable("ErrorMessageBlock")) {
                log.info("Error message is displayed");
                return true;

            } else {
                log.error("Error message is not displayed");
                Assert.fail("Error message is not displayed");
                return false;
            }

    }

    public boolean isEmptyFieldsErrorMessageForRgeistrationFormAvailable() throws NoElementFound {

            if (web.isElementPresent("EmptyFieldsErrorMessage") && web.isElementAvailable("EmptyFieldsErrorMessage")) {
                log.info("Error messages are displayed");
                return true;

            } else {
                log.error("Error message are not displayed");
                Assert.fail("Error message are not displayed");
                return false;
            }

    }



}
