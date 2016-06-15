package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.NoElementFound;
import utils.WebElementsActions;


/**
 * Created by user on 5/27/2016.
 */
public class MainPage {

    private WebElementsActions web;
    public static  final Logger log = Logger.getLogger(MainPage.class);

    public MainPage(WebDriver driver) {
        web = new WebElementsActions(driver);

    }

    public void clicLoginLink() throws NoElementFound{
        web.clickLink("LoginLink");
        log.info("Login link was clicked");

    }

    public void clickLogoutLink() throws NoElementFound{
            web.clickLink("LogoutLink");
            log.info("Logout link was clicked");

    }

    public boolean isLogoutLinkAvailable() throws NoElementFound {

            if(web.isElementPresent("LogoutLink")) {
                log.info("User is logged in successfully");
                return true;

            } else {
                log.error("User is not logged in");
                Assert.fail("User is not logged in");
                return false;

            }

    }

    public void switchToLinnenSubcategoryLandingPage() throws NoElementFound{
             web.moveToElementAndClick("DamCategorylink","LinnenSubcategory");
             log.info("Linnen item was clicked");

    }


}
