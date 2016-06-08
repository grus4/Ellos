package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
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

    public void clicLoginLink() {

        try {web.clickLink("LoginLink");
            log.info("Login link was clicked");
        } catch (NoElementFound noElementFound) {
                noElementFound.printStackTrace();
            log.error("Login link is not clicked");
            }

    }

    public void clickLogoutLink() {
        try {
            web.clickLink("LogoutLink");
            log.info("Logout link was clicked");
        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("Logout link is not clicked");
        }

    }

    public boolean isLogoutLinkAvailable() throws NoElementFound {

            if(web.isElementPresent("LogoutLink")) {
                log.info("User is logged in successfully");
                return true;

            } else {

                log.error("User is not logged in");
                return false;

            }

    }

    public void switchToLinnenSubcategoryLandingPage() {
         try {
             web.moveToElementAndClick("DamCategorylink","LinnenSubcategory");
             log.info("Linnen item was clicked");

        } catch (NoElementFound noElementFound){
            noElementFound.printStackTrace();
         }
    }


}
