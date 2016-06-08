package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
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

    public void fillLoginField(String email) {
        try {web.input("LoginEmailField",email);
            log.info("Login Email field was filled out");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Login Email field wasn't filled out");
        }

    }

    public void fillPasswordField(String password) {
        try {
            web.input("PasswordField", password);
            log.info("Password field was filled out");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Password field wasn't filled out");
        }
    }

    public void focusOnPasswordField() {
            try {
                web.clickElement("PasswordFieldPlaceholder");
                log.info("Password field was clicked");
            } catch (NoElementFound noElementFound) {
                noElementFound.printStackTrace();
                log.error("Password field was not clicked");
            }

    }

    public void clickLoginButton() {
        try {
            web.clickButton("LoginButton");
            log.info("Login Button was clicked");

        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Login button wasn't clicked");
        }
    }

    public void fillEmailRegistrationField(String emailRegistration) {
        try {
            web.input("RegistrationEmailField", emailRegistration);
            log.info("Registration Email field was filled out");
        }
        catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Registration Email field wasn't filled out");
        }
    }

    public void fillRepeatRegistrationEmailField(String repeatEmailRegistration) {
        try {
            web.input("RegistrationRepeatEmailField", repeatEmailRegistration);
            log.info("Repeat Email field was filled out");
        }
        catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Repeat Email field wasn't filled out");
        }
    }

    public void focusOnRegistrationPasswordField() {
        try {
            web.clickElement("RegistrationPasswordPlaceholder");
            log.info("Registration Password field was clicked");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Registration Password field was not clicked");
        }
    }

    public void clearRegistrationPasswordFiled() {
        try {
            web.clearField("RegistrationPasswordPlaceholder");
            log.info("Registration password placeholder was cleaned");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.info("Registration password placeholder was not cleaned");
        }
    }



    public void focusOnRepeatRegistrationPasswordField() {
        try {
            web.clickElement("RegistrationRepeatPasswordPlaceholder");
            log.info("Repeat Registration Password field was clicked");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Repeat Registration Password field was not clicked");
        }

    }

    public void clearRepeatRegistrationPasswordFiled() {
        try {
            web.clearField("RegistrationRepeatPasswordPlaceholder");
            log.info("Registration password placeholder was cleaned");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.info("Registration password placeholder was not cleaned");
        }
    }

    public void fillPasswordRegistrationField(String passworRegistrationField) {
        try {
            web.inputWithoutClean("RegitrationPasswordField", passworRegistrationField);
            log.info("Registartion password field was filled out");

        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Registartion password field wasn't filled out");
        }
    }

    public void fillRepeatRegistrationPasswordField(String repeatRegistrationPasswordField) {
        try {
            web.inputWithoutClean("RepeatRegistrationPasswordField", repeatRegistrationPasswordField);
            log.info("Repeat Registration password field was filled out");

        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Repeat Registration password field wasn't filled out");
        }
    }

    public void clickRegistrationButton() {
        try {
            web.windowScroll();
            web.clickButton("RegistrationButton");
            log.info("Registration Button was pressed");

        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Registration Button wasn't pressed");
        }


    }

    public boolean isErrorMessageAvailable() throws NoElementFound {

            if (web.isElementPresent("ErrorMessageBlock") && web.isElementAvailable("ErrorMessageBlock")) {
                log.info("Error message is displayed");
                return true;

            } else {
                log.error("Error message is not displayed");
                return false;
            }

    }

    public boolean isEmptyFieldsErrorMessageForRgeistrationFormAvailable() throws NoElementFound {

            if (web.isElementPresent("EmptyFieldsErrorMessage") && web.isElementAvailable("EmptyFieldsErrorMessage")) {
                log.info("Error messages are displayed");
                return true;

            } else {
                log.error("Error message are not displayed");
                return false;
            }

    }



}
