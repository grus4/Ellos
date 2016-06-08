package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.NoElementFound;
import utils.WebElementsActions;

/**
 * Created by user on 6/3/2016.
 */
public class SuccessfulRegistrationPage {

    private WebElementsActions web;
    Logger log = Logger.getLogger(SuccessfulRegistrationPage.class);

    public SuccessfulRegistrationPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }


    public boolean isRegistrationSuccessful() throws NoElementFound {

        if (web.isElementPresent("SuccessfullRegistrationMessage")) {
            log.info("Successfull Registration Message is displayed");
            return true;

        } else {

            log.error("Successfull Registration Message is not displayed");
            return false;
        }

    }
}
