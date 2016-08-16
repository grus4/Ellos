package pages;

import org.apache.log4j.Logger;
import org.testng.Assert;
import utils.ClassNameUtil;
import utils.WebDriverWrapper;


/**
 * Created by user on 5/27/2016.
 */
public class MainPage extends Page{

    public static  final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public MainPage(WebDriverWrapper dr) {
        super(dr);
    }

    public void clicLoginLink() {
        web.clickLink("LoginLink");
        log.info("Login link was clicked");

    }

    public void clickLogoutLink() {
        web.clickLink("LogoutLink");
        web.waitElementNotVisible("LogoutLink", 30);
        log.info("Logout link was clicked");

    }

    public boolean isLogoutLinkAvailable() {
        if(web.isElementPresent("LogoutLink")) {
            log.info("User is logged in successfully");
            return true;
        } else {
            log.error("User is not logged in");
            Assert.fail("User is not logged in");
            return false;
        }
    }

    public void switchToLinnenSubcategoryLandingPage() {
        web.moveToElementAndClick("DamCategorylink","LinnenSubcategory");
        log.info("Linnen item was clicked");

    }


}
