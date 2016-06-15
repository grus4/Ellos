package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.NoElementFound;
import utils.WebElementsActions;



public class CategoryLandingPage {
    private WebElementsActions web;

    public static final Logger log = Logger.getLogger(CategoryLandingPage.class);

    public CategoryLandingPage(WebDriver driver) {
        web = new WebElementsActions(driver);
    }


    public void switchToFirstProductDetailPage() {
        try {
            web.moveToElementAndClick("FirstProductLinnenLP","ActiveThumbnail");
            log.info("the first element was clicked");
            web.windowScroll();



        } catch (NoElementFound noElementFound) {
            noElementFound.printStackTrace();
            log.error("the first element wasn't clicked");
        }

    }


}
