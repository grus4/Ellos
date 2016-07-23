package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.NoElementFound;
import utils.WebDriverWrapper;
import utils.WebElementsActions;

/**
 * Created by user on 6/3/2016.
 */
public class SuccessfulRegistrationPage extends Page{

    Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public SuccessfulRegistrationPage(WebDriverWrapper dr) {
        super(dr);
    }

    public boolean isRegistrationSuccessful() throws NoElementFound {

        if (web.isElementPresent("SuccessfullRegistrationMessage")) {
            log.info("Successfull Registration Message is displayed");
            return true;

        } else {
            log.error("Successfull Registration Message is not displayed");
            Assert.fail("Successfull Registration Message is not displayed");
            return false;
        }

    }
}
