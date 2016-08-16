package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.*;

/**
 * Created by user on 5/29/2016.
 */
public class LoginPage extends Page{

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public LoginPage(WebDriverWrapper dr) {
        super(dr);
    }

    public void fillLoginField(String email) {
        web.input("LoginEmailField",email);
        log.info("Login Email field was filled out");

    }

    public void fillPasswordField(String password){
            web.input("PasswordField", password);
            log.info("Password field was filled out");

    }

    public void focusOnPasswordField() {
                web.clickElement("PasswordFieldPlaceholder");
                log.info("Password field was clicked");

    }

    public void clickLoginButton() {
            web.clickButton("LoginButton");
            log.info("Login Button was clicked");

    }

    public void fillEmailRegistrationField(String emailRegistration) {
            web.input("RegistrationEmailField", emailRegistration);
            log.info("Registration Email field was filled out");

    }

    public void fillRepeatRegistrationEmailField(String repeatEmailRegistration) {
            web.input("RegistrationRepeatEmailField", repeatEmailRegistration);
            log.info("Repeat Email field was filled out");

    }

    public void focusOnRegistrationPasswordField() {
            web.clickElement("RegistrationPasswordPlaceholder");
            log.info("Registration Password field was clicked");

    }

    public void clearRegistrationPasswordFiled() {
            web.clearField("RegistrationPasswordPlaceholder");
            log.info("Registration password placeholder was cleaned");

    }



    public void focusOnRepeatRegistrationPasswordField() {
            web.clickElement("RegistrationRepeatPasswordPlaceholder");
            log.info("Repeat Registration Password field was clicked");

    }

    public void clearRepeatRegistrationPasswordFiled() {
            web.clearField("RegistrationRepeatPasswordPlaceholder");
            log.info("Registration password placeholder was cleaned");

    }

    public void fillPasswordRegistrationField(String passworRegistrationField) {
            web.inputWithoutClean("RegitrationPasswordField", passworRegistrationField);
            log.info("Registartion password field was filled out");

    }

    public void fillRepeatRegistrationPasswordField(String repeatRegistrationPasswordField) {
            web.inputWithoutClean("RepeatRegistrationPasswordField", repeatRegistrationPasswordField);
            log.info("Repeat Registration password field was filled out");

    }

    public void clickRegistrationButton() {
            web.windowScroll();
            web.clickButton("RegistrationButton");
            log.info("Registration Button was pressed");

    }

    public boolean isErrorMessageAvailable()  {

            if (web.isElementPresent("ErrorMessageBlock") && web.isElementAvailable("ErrorMessageBlock")) {
                log.info("Error message is displayed");
                return true;

            } else {
                log.error("Error message is not displayed");
                Assert.fail("Error message is not displayed");
                return false;
            }

    }

    public boolean isEmptyFieldsErrorMessageForRgeistrationFormAvailable() {

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
