package pages;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import utils.ClassNameUtil;
import utils.NoElementFound;
import utils.WebDriverWrapper;
import utils.WebElementsActions;



public class CategoryLandingPage extends Page {

    public static final Logger log = Logger.getLogger(ClassNameUtil.getCurrentClassName());

    public CategoryLandingPage(WebDriverWrapper dr) {
        super(dr);

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
